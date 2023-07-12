package com.mooncloak.kodetools.kenv.parse

import com.mooncloak.kodetools.kenv.EnvironmentVariable
import com.mooncloak.kodetools.kenv.exception.DotEnvParseException
import com.mooncloak.kodetools.kenv.util.IndexedString
import com.mooncloak.kodetools.kenv.util.endExclusive
import com.mooncloak.kodetools.kenv.util.indexOfFirst
import okio.Source

/**
 * A component that is responsible for parsing a Dot Env (".env") [String] file to obtain a collection of
 * [EnvironmentVariable]s.
 *
 * @property [options] The options that are used during the parsing process.
 */
class DotEnvParser internal constructor(
    private val options: Options = Options()
) {

    /**
     * A convenience function for invoking the [parse] with a [LineReaderSource] obtained from the provided [source].
     *
     * @see [parse]
     */
    @Throws(DotEnvParseException::class)
    fun parse(source: Source): List<EnvironmentVariable> =
        parse(reader = LineReaderSource(source = source))

    /**
     * A convenience function for invoking the [parse] with a [LineReaderSource] obtained from the provided [String]
     * [value].
     *
     * @see [parse]
     */
    @Throws(DotEnvParseException::class)
    fun parse(value: String): List<EnvironmentVariable> =
        parse(reader = LineReaderSource(utf8String = value))


    /**
     * Parses the environment variables from each [String] line retrieved from the provided [reader] and returns the
     * resulting [List] of [EnvironmentVariable]s.
     *
     * @param [reader] The [LineReaderSource] that will be used to retrieve [String] lines that will each be parsed
     * individually for environment variables.
     *
     * @throws [DotEnvParseException] If an error was encountered during the parsing of the environment variables.
     * Certain exceptions can be configured via the [Options] passed in during the construction of this [DotEnvParser]
     * instance.
     *
     * @return A [List] of [EnvironmentVariable]s parsed from all the [String] lines read from the provided [reader].
     */
    @Throws(DotEnvParseException::class)
    internal fun parse(reader: LineReaderSource): List<EnvironmentVariable> {
        val variables = mutableListOf<EnvironmentVariable>()
        val values = mutableMapOf<String, String>()

        var line = reader.readLine()

        while (line != null) {
            val isComment = parseIsComment(line = line)

            if (!isComment) {
                val export = parseExport(line = line)
                val key = parseKey(start = export?.endExclusive ?: 0, line = line)

                if (key != null) {
                    try {
                        val equals = parseEquals(start = key.endExclusive, line = line)
                        val value = parseValue(
                            start = equals?.endExclusive ?: key.endExclusive,
                            line = line,
                            reader = reader
                        )

                        if (value != null) {
                            val formattedValue = value.interpolate(values = values)
                            val variable = EnvironmentVariable(
                                key = key.value,
                                value = EnvironmentVariable.Value(value = formattedValue)
                            )

                            variables.add(variable)
                            values[key.value] = formattedValue
                        } else if (!options.includeEmptyValues) {
                            throw DotEnvParseException(message = "Environment variable '$key' was missing value.")
                        }
                    } catch (e: IndexOutOfBoundsException) {
                        // We will get an index out of bounds exception if there was a key with no equals sign or value.
                        // But, depending on the options, we may allow these "empty" values. So, catch the exception
                        // and either return the empty value or throw the exception depending on the options.
                        if (!options.includeEmptyValues) {
                            throw DotEnvParseException(
                                message = "Environment variable '$key' was missing value.",
                                cause = e
                            )
                        } else {
                            val variable = EnvironmentVariable(
                                key = key.value,
                                value = EnvironmentVariable.Value(value = "")
                            )

                            variables.add(variable)
                            values[key.value] = ""
                        }
                    }
                }
            }

            line = reader.readLine()
        }

        return variables.toList()
    }

    /**
     * Determines if this line is a comment, and therefore can be ignored when parsing for environment variables. A
     * supported comment line must meet the following criteria:
     * - The first non-whitespace characters must begin this either a hash ('#'), two forward slashes ('/'), an
     *   asterisk ('*'), or a forward slash followed by an asterisk.
     *
     * @return `true` if this line is considered a comment and can be ignored, `false` otherwise.
     */
    internal fun parseIsComment(line: String): Boolean {
        if (line.isEmpty()) return false

        val startIndex = line.indexOfFirst { !it.isWhitespace() }

        if (startIndex == -1) return false

        val substring = line.substring(startIndex = startIndex)

        return substring.startsWith('#') ||
                substring.startsWith('*') ||
                substring.startsWith("//") ||
                substring.startsWith("/*")
    }

    /**
     * Parses an "export" modifier for an environment variable from the provided [line] [String].
     *
     * **Note:** An export modifier is only considered valid, and will only be returned, if it is at the beginning of
     * the [line] [String], ignoring whitespace (defined by the [Char.isWhitespace] function), and contains a
     * whitespace character after it.
     *
     * @param [start] The index to start parsing at in the provided [line] [String].
     *
     * @param [line] The [String] containing the "export" modifier.
     *
     * @throws [IndexOutOfBoundsException] if the provided [start] index is less than zero or greater than the last
     * index in the provided [line] [String].
     *
     * @return An [IndexedString] value containing the "export" modifier as the [IndexedValue.value] and the
     * positioning the modifier resides within the provided [line] value, or `null` if there was no "export" modifier
     * at the beginning of the [line] [String].
     */
    internal fun parseExport(start: Int = 0, line: String): IndexedString? {
        if (start < 0) throw IndexOutOfBoundsException("'start' index must be greater than or equal to zero. start = $start")
        if (line.isNotEmpty() && start >= line.length) throw IndexOutOfBoundsException("'start' index must be less than 'line.length'. start = $start")

        if (line.isEmpty()) return null

        val startIndex = line.indexOfFirst(start = start) { !it.isWhitespace() }

        if (startIndex == -1) return null

        if (line.substring(startIndex).startsWith("export ")) {
            return IndexedString(
                index = startIndex,
                value = "export"
            )
        }

        return null
    }

    /**
     * Parses an environment variable key from the provided [line] [String]. A supported environment variable key must
     * meet the following criteria:
     * - Must begin with a Unicode letter (defined by the [Char.isLetter] function) or an underscore ('_'). Initial
     *   whitespace (defined by the [Char.isWhitespace] function) is ignored.
     * - Must only contain Unicode letters or digits (defined by the [Char.isLetterOrDigit] function), underscores
     *   ('_'), or periods ('.').
     * - Must be one or more characters in length.
     * - Will be terminated by the first character reached that is whitespace (defined by the [Char.isWhitespace]
     *   function), an equal sign ('='), or a new line character ('\n'). Meaning the key is the characters before one
     *   of these characters was reached.
     *
     * @param [start] The index to start parsing at in the provided [line] [String].
     *
     * @param [line] The [String] containing an environment variable key.
     *
     * @throws [IndexOutOfBoundsException] if the provided [start] index is less than zero or greater than the last
     * index in the provided [line] [String].
     *
     * @return An [IndexedString] value containing the key as the [IndexedValue.value] and the positioning the key
     * resides within the provided [line] value, or `null` if any unsupported characters were reached (meaning it was
     * not considered a valid key).
     */
    @Throws(IndexOutOfBoundsException::class)
    internal fun parseKey(start: Int = 0, line: String): IndexedString? {
        if (start < 0) throw IndexOutOfBoundsException("'start' index must be greater than or equal to zero. start = $start")
        if (line.isNotEmpty() && start >= line.length) throw IndexOutOfBoundsException("'start' index must be less than 'line.length'. start = $start")

        // If the line is empty (length == 0), then there is no key value on the line, so return `null`.
        if (line.isEmpty()) return null

        // First, find the startIndex value which is the first non-whitespace character.
        val startIndex = line.indexOfFirst(start = start) { !it.isWhitespace() }

        // If all the characters were whitespace (the String was considered blank), return `null`.
        if (startIndex == -1 || startIndex > line.lastIndex) return null

        // Then, make sure that the first character is valid. Must be a letter or underscore.
        val firstChar = line[startIndex]
        val isValidStartChar = firstChar.isLetter() || firstChar == '_'
        if (!isValidStartChar) return null

        // Then, construct the key. Return `null` if a character is invalid. Break when we first encounter whitespace
        // or an equals sign.
        val keyBuilder = StringBuilder()
        var index = startIndex
        while (index <= line.lastIndex) {
            val char = line[index]

            if (char.isWhitespace() || char == '=' || char == '\n') {
                break
            } else if (char.isLetterOrDigit() || char == '_' || char == '.') {
                keyBuilder.append(char)
            } else {
                return null
            }

            index++
        }

        // If the start and end indices are invalid, return `null`.
        if (startIndex >= index) return null

        // Finally, return the result of the key and its position within the line.
        return IndexedString(
            index = startIndex,
            value = keyBuilder.toString()
        )
    }

    /**
     * Parses the provided [line] [String] beginning at the provided [start] index within the [line] [String], looking
     * for an equals sign ('=') that separates an environment variable key from its value. There must not be any
     * characters other than whitespace (defined by the [Char.isWhitespace] function) within the [line] [String]
     * beginning from the [start] index until an equals sign is encountered, otherwise the [String] is considered
     * invalid and a [DotEnvParseException] will be thrown.
     *
     * @param [start] The index to start parsing at in the provided [line] [String].
     *
     * @param [line] The [String] containing an equals sign for an environment variable.
     *
     * @throws [DotEnvParseException] if an invalid character (not whitespace defined by the [Char.isWhitespace]
     * function) was encountered before an equals sign.
     *
     * @throws [IndexOutOfBoundsException] if the provided [start] index is less than zero or greater than the last
     * index in the provided [line] [String].
     *
     * @return An [IndexedString] containing the equals sign as the [IndexedValue.value] and the positioning the
     * equals sign resides within the [line] value, or `null` if there was no equals sign found.
     */
    @Throws(DotEnvParseException::class, IndexOutOfBoundsException::class)
    internal fun parseEquals(start: Int, line: String): IndexedString? {
        if (start < 0) throw IndexOutOfBoundsException("'start' index must be greater than or equal to zero. start = $start")
        if (line.isNotEmpty() && start >= line.length) throw IndexOutOfBoundsException("'start' index must be less than 'line.length'. start = $start")

        if (line.isEmpty()) return null

        var index = start

        while (index < line.length) {
            val char = line[index]

            if (char == '=') {
                return IndexedString(
                    index = index,
                    value = char.toString()
                )
            } else if (!char.isWhitespace()) {
                throw DotEnvParseException(message = "Invalid character between key and equals sign: $char")
            }

            index++
        }

        return null
    }

    /**
     * Parses the value portion of an environment variable assignment from the provided [line] [String] value beginning
     * at the provided [start] index. A supported environment variable value must meet the following criteria:
     * - May be a single line or multiline value.
     * - A single line value may start with a single or double quotation mark.
     * - A multiline value must start and end with three matching, single or double, quotation mark values.
     * - A single line value starting with a single quotation mark does not get interpolated with environment variable
     *   references.
     * - A single line starting with a double quotation mark, or no quotation mark, may contain environment variable
     *   references to previously parsed environment variables that will be replaced with their values.
     * - A single line value with no surrounding quotation marks may not contain any whitespace.
     * - A single line value is terminated by the first non-escaped ending quotation mark, a whitespace if it is not
     *   surrounded by quotation marks, or the end of the line.
     * - A multiline value is terminated by a quotation mark set that matches its starting quotation mark set.
     *
     * @param [start] The index to start parsing at in the provided [line] [String].
     *
     * @param [line] The [String] containing, at least the start of, an environment variable value.
     *
     * @throws [IndexOutOfBoundsException] if the provided [start] index is less than zero or greater than the last
     * index in the provided [line] [String].
     *
     * @return The environment variable value, or `null` if there was no value.
     */
    @Throws(IndexOutOfBoundsException::class)
    internal fun parseValue(
        start: Int,
        line: String,
        reader: LineReaderSource
    ): String? {
        if (start < 0) throw IndexOutOfBoundsException("'start' index must be greater than or equal to zero. start = $start")
        if (line.isNotEmpty() && start >= line.length) throw IndexOutOfBoundsException("'start' index must be less than 'line.length'. start = $start")

        if (line.isEmpty()) return null

        val startIndex = line.indexOfFirst(start = start) { !it.isWhitespace() }

        if (startIndex == -1) return null

        val valueStart = line.substring(startIndex = startIndex, endIndex = minOf(startIndex + 3, line.length))

        return when {
            valueStart == "\"\"\"" -> parseMultilineValue(
                start = startIndex + 3,
                line = line,
                quote = '"',
                reader = reader
            )

            valueStart == "'''" -> parseMultilineValue(
                start = startIndex + 3,
                line = line,
                quote = '\'',
                reader = reader
            )

            valueStart.startsWith('\'') -> parseSingleLineValue(
                start = startIndex + 1,
                line = line,
                quote = '\''
            )?.value

            valueStart.startsWith('"') -> parseSingleLineValue(
                start = startIndex + 1,
                line = line,
                quote = '"'
            )?.value

            else -> parseSingleLineValue(
                start = startIndex,
                line = line,
                quote = null
            )?.value
        }
    }

    /**
     * Parses the provided [line] [String], beginning at the provided [start] index value, as a single line environment
     * variable value. A supported single line environment variable value must meet the following criteria:
     * - May begin with a single or double quote. Note that the [start] index value will begin after the first quote if
     *   one is provided.
     * - May contain escaped quotation mark characters (preceded with a backslash). **Note:** escaping backslashes
     *   ("\\") is not supported.
     * - Must not contain whitespace characters (defined by the [Char.isWhitespace] function), if it is not surrounded
     *   by quotation marks.
     * - May contain references to previously defined environment variables that will be interpolated later (not
     *   handled by this function). To reference previously defined environment variables, surround the environment
     *   variable name with "${" and "}". For instance, "${OTHER}" references an environment variable with the name
     *   "OTHER".
     * - Will terminate if the value began with a quotation mark and a non-escaped matching quotation mark was
     *   encountered, the value did not begin with a quotation mark and a whitespace character was encountered, or the
     *   end of the line was reached.
     *
     * **Note:** That this function should be invoked where the [start] index value starts the value. That is if the
     * environment variable value began with a quotation, this [start] value will be the index after that first
     * quotation. This is done because the parser must lookahead to determine whether the value is a single or
     * multiline value, which means it can start the index at the first value character.
     *
     * @param [start] The index to start parsing at in the provided [line] [String].
     *
     * @param [line] The [String] containing an environment variable value.
     *
     * @param [quote] The quotation mark character that is surrounding this environment variable value, or `null` if
     * there is no surrounding quotation marks.
     *
     * @throws [IndexOutOfBoundsException] if the provided [start] index is less than zero or greater than the last
     * index in the provided [line] [String].
     *
     * @return An [IndexedString] containing the environment variable value as the [IndexedValue.value] and the
     * positioning of where the environment variable value resides within the [line] value, or `null` if there was no
     * value because the line was empty.
     */
    @Throws(IndexOutOfBoundsException::class)
    internal fun parseSingleLineValue(
        start: Int,
        line: String,
        quote: Char?
    ): IndexedString? {
        if (start < 0) throw IndexOutOfBoundsException("'start' index must be greater than or equal to zero. start = $start")
        if (line.isNotEmpty() && start >= line.length) throw IndexOutOfBoundsException("'start' index must be less than 'line.length'. start = $start")

        if (line.isEmpty()) return null

        // If the first character is the matching ending quotation mark, just return an empty value.
        // Note that this is different from the isEmpty check above, because this is an explicitly defined empty value
        // with surrounding quotation marks.
        if (line[start] == quote) {
            return IndexedString(
                index = start,
                value = ""
            )
        }

        val valueBuilder = StringBuilder()
        var index = start
        var escaped = false

        while (index < line.length) {
            val char = line[index]

            // Break at the ending quote value, or if the value is not quoted, then the first whitespace character.
            // Ignore quote values that are escaped (the previous character was a backslash).
            if ((char == quote && !escaped) || (quote == null && char.isWhitespace())) {
                break
            } else {
                valueBuilder.append(char)
            }

            if (char == '\\') {
                escaped = true
            }

            index++
        }

        return IndexedString(
            index = start,
            value = valueBuilder.toString()
        )
    }

    /**
     * Parses the provided [line] [String], beginning at the provided [start] index value, as a single line of a
     * multiline environment variable value. A supported multiline environment variable value must meet the following
     * criteria:
     * - Must begin with a set of three single or double quotation marks. Note that the [start] index value will begin
     *   after the first three quotes.
     * - Must end with a matching set of three single or double quotation marks. Any character on the same line after
     *   the ending quotation mark set is ignored.
     * - May contain quotation mark characters (not in a set of three).
     * - May contain whitespace characters (defined by the [Char.isWhitespace] function).
     * - May contain references to previously defined environment variables that will be interpolated later (not
     *   handled by this function). To reference previously defined environment variables, surround the environment
     *   variable name with "${" and "}". For instance, "${OTHER}" references an environment variable with the name
     *   "OTHER".
     *
     * **Note:** That this function should be invoked where the [start] index value starts the value. This is done
     * because the parser must lookahead to determine whether the value is a single or multiline value, which means it
     * can start the index at the first value character.
     *
     * **Note:** That this parses only a single line of a multiline environment variable value.
     *
     * @param [start] The index to start parsing at in the provided [line] [String].
     *
     * @param [line] The [String] containing an environment variable value.
     *
     * @throws [IndexOutOfBoundsException] if the provided [start] index is less than zero or greater than the last
     * index in the provided [line] [String].
     *
     * @return A [MultilineParseState] containing an [IndexedString] as the [MultilineParseState.value] which contains
     * the environment variable value as the [IndexedValue.value] and the positioning of where the environment
     * variable value resides within the [line] value. The returned [MultilineParseState] determines whether we have
     * finished (reached the ending quotation mark set) or still need to proceed to read the next line to continue
     * forming the multiline String value.
     */
    @Throws(IndexOutOfBoundsException::class)
    internal fun parseSingleLineOfMultilineValue(
        start: Int,
        line: String,
        quote: Char
    ): MultilineParseState {
        if (start < 0) throw IndexOutOfBoundsException("'start' index must be greater than or equal to zero. start = $start")
        if (line.isNotEmpty() && start >= line.length) throw IndexOutOfBoundsException("'start' index must be less than 'line.length'. start = $start")

        // If the first characters are the matching ending quotation mark set, or this line is empty, just return an
        // empty value with the appropriate state.
        if (line.isEmpty()) {
            return MultilineParseState.InProgress(
                value = IndexedString(
                    index = start,
                    value = ""
                )
            )
        }

        val valueBuilder = StringBuilder()
        var index = start

        while (index < line.length) {
            val char = line[index]

            // Break if we have encountered the matching quotation mark set that indicates the end of the multiline
            // string value.
            if (char == quote && (index + 2) < line.length && line[index + 1] == quote && line[index + 2] == quote) {
                return MultilineParseState.Finished(
                    value = IndexedString(
                        index = start,
                        value = valueBuilder.toString()
                    )
                )
            } else {
                valueBuilder.append(char)
            }

            index++
        }

        return MultilineParseState.InProgress(
            value = IndexedString(
                index = start,
                value = valueBuilder.toString()
            )
        )
    }

    /**
     * Parses the [String] value for a multiline environment variable value, beginning at the provided [start] index
     * value in the provided [line], and continuing to process each subsequent line using the provided [reader] to
     * obtain the lines, until the matching ending quotation mark set is reached. A supported multiline environment
     * variable value must meet the following criteria:
     * - Must begin with a set of three single or double quotation marks. Note that the [start] index value will begin
     *   after the first three quotes.
     * - Must end with a matching set of three single or double quotation marks. Any character on the same line after
     *   the ending quotation mark set is ignored.
     * - May contain quotation mark characters (not in a set of three).
     * - May contain whitespace characters (defined by the [Char.isWhitespace] function).
     * - May contain references to previously defined environment variables that will be interpolated later (not
     *   handled by this function). To reference previously defined environment variables, surround the environment
     *   variable name with "${" and "}". For instance, "${OTHER}" references an environment variable with the name
     *   "OTHER".
     *
     * **Note:** That this function should be invoked where the [start] index value starts the value. This is done
     * because the parser must lookahead to determine whether the value is a single or multiline value, which means it
     * can start the index at the first value character.
     *
     * @param [start] The index to start parsing at in the provided [line] [String].
     *
     * @param [line] The [String] containing an environment variable value.
     *
     * @throws [IndexOutOfBoundsException] if the provided [start] index is less than zero or greater than the last
     * index in the provided [line] [String].
     *
     * @return The [String] value of a multiline environment variable value.
     */
    @Throws(IndexOutOfBoundsException::class)
    internal fun parseMultilineValue(
        start: Int,
        line: String,
        quote: Char,
        reader: LineReaderSource
    ): String {
        if (start < 0) throw IndexOutOfBoundsException("'start' index must be greater than or equal to zero. start = $start")
        if (line.isNotEmpty() && start >= line.length) throw IndexOutOfBoundsException("'start' index must be less than 'line.length'. start = $start")

        val lines = mutableListOf<String>()

        var currentLine: String? = line
        var startIndex = start

        while (currentLine != null) {
            val state = parseSingleLineOfMultilineValue(
                start = startIndex,
                line = currentLine,
                quote = quote
            )

            lines.add(state.value.value)

            // If we encountered a non-escaped ending quotation set, then terminate the multiline String.
            if (state.isFinished) {
                break
            }

            currentLine = reader.readLine()
            startIndex = 0
        }

        return lines.joinToString(separator = "\n")
    }

    /**
     * Parses this [String] environment variable value, replacing interpolated environment variable references with
     * their actual values, returning the resulting formatted [String]. Environment variable references within an
     * environment variable value must meet the following criteria:
     * - Must begin with a non-escaped (not preceded by a backslash) '$' character. **Note:** escaping backslashes
     *   ("\\") is not supported.
     * - The '$' character must be followed by a '{' character.
     * - Must be ended with a '}' character.
     * - The [String] within the '{' and '}' characters, must be the environment variable key that is being referenced.
     * - The referenced key should be a supported environment variable key.
     * - The referenced key must contain at least one character.
     * - A reference to a non-existing environment variable will result in the value "null" replacing the reference.
     * - Environment variable references must only be back referencing in the current context. Forward referencing, or
     *   external referencing is not supported.
     *
     * @param [values] A [Map] of environment variable keys to already formatted environment variable values. This
     * should contain all the previously parsed and formatted environment variables. Forward referencing of variables
     * is not supported. Defaults to an empty [Map].
     *
     * @throws [DotEnvParseException] If an exception occurred during parsing of environment variable references, such
     * as a non-escaped opening of an environment variable reference without a matching closing bracket.
     *
     * @return A formatted environment variable [String] value with the references to other existing environment
     * variables swapped out with their real values.
     */
    @Throws(DotEnvParseException::class)
    internal fun String.interpolate(values: Map<String, String> = emptyMap()): String {
        val builder = StringBuilder()
        var escaped = false
        var index = 0

        while (index < this.length) {
            val char = this[index]

            if (char == '$' && !escaped && index + 3 < this.length && this[index + 1] == '{') {
                index += 2

                val endingBracketIndex = this.indexOfFirst(start = index) { it == '}' }

                if (endingBracketIndex == -1) {
                    throw DotEnvParseException(message = "Environment variable reference did not have a closing '}'. value = $this")
                }

                val key = this.substring(startIndex = index, endIndex = endingBracketIndex)

                if (key.isEmpty()) {
                    throw DotEnvParseException(message = "Environment variable reference must contain at least one character for the key name. key = $key")
                }

                builder.append(values[key])

                index = endingBracketIndex + 1

                continue
            } else {
                builder.append(char)
            }

            if (char == '\\') {
                escaped = true
            }

            index++
        }

        return builder.toString()
    }

    /**
     * Parsing options for a [DotEnvParser] instance.
     *
     * @property [includeEmptyValues] If this is `false` and an environment variable is encountered that does not have
     * an associated value assigned to it, a [DotEnvParseException] will be thrown, otherwise, an environment variable
     * will be created with an empty [String] as its value. Defaults to `false`.
     */
    class Options(
        val includeEmptyValues: Boolean = false
    ) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Options) return false

            return includeEmptyValues == other.includeEmptyValues
        }

        override fun hashCode(): Int = includeEmptyValues.hashCode()

        override fun toString(): String = "Options(includeEmptyValues=$includeEmptyValues)"
    }
}
