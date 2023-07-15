package com.mooncloak.kodetools.kenv.parse

import com.mooncloak.kodetools.kenv.EnvironmentVariable
import com.mooncloak.kodetools.kenv.exception.DotEnvParseException
import com.mooncloak.kodetools.kenv.util.IndexedString
import kotlin.test.*

class DotEnvParserTest {

    @Test
    fun parse_is_comment_returns_true_for_hash() {
        val parser = DotEnvParser()

        assertTrue(actual = parser.parseIsComment(line = "# comment"))
        assertTrue(actual = parser.parseIsComment(line = "#comment"))
        assertTrue(actual = parser.parseIsComment(line = "   # comment"))
    }

    @Test
    fun parse_is_comment_returns_true_for_two_forward_slashes() {
        val parser = DotEnvParser()

        assertTrue(actual = parser.parseIsComment(line = "// comment"))
        assertTrue(actual = parser.parseIsComment(line = "//comment"))
        assertTrue(actual = parser.parseIsComment(line = "   // comment"))
    }

    @Test
    fun parse_is_comment_returns_true_for_asterisk() {
        val parser = DotEnvParser()

        assertTrue(actual = parser.parseIsComment(line = "* comment"))
        assertTrue(actual = parser.parseIsComment(line = "*comment"))
        assertTrue(actual = parser.parseIsComment(line = "   * comment"))
    }

    @Test
    fun parse_is_comment_returns_true_for_forward_slash_followed_by_asterisk() {
        val parser = DotEnvParser()

        assertTrue(actual = parser.parseIsComment(line = "/* comment"))
        assertTrue(actual = parser.parseIsComment(line = "/*comment"))
        assertTrue(actual = parser.parseIsComment(line = "   /* comment"))
    }

    @Test
    fun parse_is_comment_returns_false_for_any_other_character() {
        val parser = DotEnvParser()

        assertFalse(actual = parser.parseIsComment(line = ""))
        assertFalse(actual = parser.parseIsComment(line = "   "))
        assertFalse(actual = parser.parseIsComment(line = "comment"))
        assertFalse(actual = parser.parseIsComment(line = " comment"))
        assertFalse(actual = parser.parseIsComment(line = "/"))
        assertFalse(actual = parser.parseIsComment(line = "\\"))
        assertFalse(actual = parser.parseIsComment(line = "1"))
        assertFalse(actual = parser.parseIsComment(line = "export"))
        assertFalse(actual = parser.parseIsComment(line = "abc"))
        assertFalse(actual = parser.parseIsComment(line = "="))
    }

    @Test
    fun parse_export_returns_null_for_empty_string() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseExport(line = ""))
    }

    @Test
    fun parse_export_returns_null_for_blank_string() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseExport(line = "    "))
    }

    @Test
    fun parse_export_returns_null_for_no_export_modifier() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseExport(line = "abc123"))
    }

    @Test
    fun parse_export_returns_null_for_export_without_trailing_whitespace() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseExport(line = " export"))
        assertEquals(expected = null, actual = parser.parseExport(line = " export1"))
        assertEquals(expected = null, actual = parser.parseExport(line = " exporta"))
        assertEquals(expected = null, actual = parser.parseExport(line = " export_"))
    }

    @Test
    fun parse_export_returns_null_for_export_after_non_whitespace_characters() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseExport(line = " abc123 export"))
    }

    @Test
    fun parse_export_returns_valid_value() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(
                index = 1,
                value = "export"
            ),
            actual = parser.parseExport(line = " export ")
        )
    }

    @Test
    fun key_must_begin_with_a_letter_or_underscore() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseKey(line = ""))
        assertEquals(expected = null, actual = parser.parseKey(line = "#abc123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "1abc"))
        assertEquals(expected = null, actual = parser.parseKey(line = ".abc123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "-abc"))

        assertEquals(
            expected = IndexedString(index = 0, value = "abc123"),
            actual = parser.parseKey(line = "abc123")
        )
        assertEquals(
            expected = IndexedString(index = 0, value = "_abc123"),
            actual = parser.parseKey(line = "_abc123")
        )
    }

    @Test
    fun parse_key_starts_at_provided_start_index() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(
                index = 3,
                value = "abc123"
            ),
            actual = parser.parseKey(start = 2, line = "!# abc123")
        )
    }

    @Test
    fun parse_key_throws_exception_for_start_less_than_zero() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseKey(start = -1, line = "abc123")
        }
    }

    @Test
    fun parse_key_throws_exception_for_start_greater_than_last_index() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseKey(start = 6, line = "abc123")
        }
    }

    @Test
    fun whitespace_before_key_is_trimmed() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(index = 1, value = "abc123"),
            actual = parser.parseKey(line = " abc123")
        )
        assertEquals(
            expected = IndexedString(index = 3, value = "_abc123"),
            actual = parser.parseKey(line = "   _abc123")
        )
    }

    @Test
    fun empty_and_blank_lines_are_invalid_keys() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseKey(line = ""))
        assertEquals(expected = null, actual = parser.parseKey(line = "      "))
    }

    @Test
    fun key_must_contain_only_valid_characters() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseKey(line = "abc/123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc\\123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc-123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc+123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc&123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc%123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc$123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc#123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc@123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc!123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc*123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc(123"))
        assertEquals(expected = null, actual = parser.parseKey(line = "abc)123"))

        assertEquals(
            expected = IndexedString(index = 0, value = "abc123"),
            actual = parser.parseKey(line = "abc123")
        )
        assertEquals(
            expected = IndexedString(index = 0, value = "abc_123"),
            actual = parser.parseKey(line = "abc_123")
        )
        assertEquals(
            expected = IndexedString(index = 0, value = "abc.123"),
            actual = parser.parseKey(line = "abc.123")
        )
    }

    @Test
    fun equals_sign_terminates_key() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(index = 0, value = "abc123"),
            actual = parser.parseKey(line = "abc123=")
        )
    }

    @Test
    fun whitespace_terminates_key() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(index = 0, value = "abc123"),
            actual = parser.parseKey(line = "abc123 ")
        )
    }

    @Test
    fun new_line_terminates_key() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(index = 0, value = "abc123"),
            actual = parser.parseKey(line = "abc123\n")
        )
    }

    @Test
    fun parse_equals_throws_exception_for_start_less_than_zero() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseEquals(start = -1, line = "abc123")
        }
    }

    @Test
    fun parse_equals_throws_exception_for_start_greater_than_last_index() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseEquals(start = 6, line = "abc123")
        }
    }

    @Test
    fun parse_equals_throws_exception_for_non_whitespace_char_before_equals() {
        val parser = DotEnvParser()

        assertFailsWith(DotEnvParseException::class) {
            parser.parseEquals(start = 0, line = " a=")
        }
    }

    @Test
    fun parse_equals_returns_null_for_empty_string() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseEquals(start = 0, line = ""))
    }

    @Test
    fun parse_equals_returns_null_for_blank_string() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseEquals(start = 0, line = "   "))
    }

    @Test
    fun parse_equals_returns_indexed_equals() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(index = 2, value = "="),
            actual = parser.parseEquals(start = 0, line = "  = ")
        )
    }

    @Test
    fun parse_equals_returns_first_equals_encountered() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(index = 2, value = "="),
            actual = parser.parseEquals(start = 0, line = "  === = ")
        )
    }

    @Test
    fun parse_single_line_value_throws_exception_for_start_less_than_zero() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseSingleLineValue(start = -1, line = "abc123", quote = null)
        }
    }

    @Test
    fun parse_single_line_value_throws_exception_for_start_greater_than_last_index() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseSingleLineValue(start = 6, line = "abc123", quote = null)
        }
    }

    @Test
    fun parse_single_line_value_ends_at_first_matching_quotation_mark() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = ""
            ),
            actual = parser.parseSingleLineValue(start = 0, line = "\"", quote = '"')
        )

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = ""
            ),
            actual = parser.parseSingleLineValue(start = 0, line = "'", quote = '\'')
        )

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc"
            ),
            actual = parser.parseSingleLineValue(start = 0, line = "abc\"", quote = '"')
        )

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc"
            ),
            actual = parser.parseSingleLineValue(start = 0, line = "abc'", quote = '\'')
        )
    }

    @Test
    fun parse_single_line_value_escaped_quotation_marks_are_ignored() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc\\\"123"
            ),
            actual = parser.parseSingleLineValue(start = 0, line = "abc\\\"123", quote = '"')
        )

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc\\\'123"
            ),
            actual = parser.parseSingleLineValue(start = 0, line = "abc\\\'123", quote = '\'')
        )
    }

    @Test
    fun parse_single_line_value_whitespace_character_terminates_for_no_quotation_marks() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc"
            ),
            actual = parser.parseSingleLineValue(start = 0, line = "abc 123", quote = null)
        )
    }

    @Test
    fun parse_single_line_value_whitespace_character_does_not_terminates_for_quotation_marks() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc 123"
            ),
            actual = parser.parseSingleLineValue(start = 0, line = "abc 123", quote = '"')
        )
        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc 123"
            ),
            actual = parser.parseSingleLineValue(start = 0, line = "abc 123", quote = '\'')
        )
    }

    @Test
    fun parse_single_line_of_multiline_string_value_throws_exception_for_start_less_than_zero() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseSingleLineOfMultilineValue(start = -1, line = "abc123", quote = '"')
        }
    }

    @Test
    fun parse_single_line_of_multiline_string_value_throws_exception_for_start_greater_than_last_index() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseSingleLineOfMultilineValue(start = 6, line = "abc123", quote = '"')
        }
    }

    @Test
    fun parse_single_line_of_multiline_string_value_returns_entire_line() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc123 \${other}  "
            ),
            actual = parser.parseSingleLineOfMultilineValue(start = 0, line = "abc123 \${other}  ", quote = '"').value
        )
        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc123 \${other}  "
            ),
            actual = parser.parseSingleLineOfMultilineValue(start = 0, line = "abc123 \${other}  ", quote = '\'').value
        )
    }

    @Test
    fun parse_single_line_of_multiline_string_value_terminates_at_ending_quotation_set() {
        val parser = DotEnvParser()

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc123 "
            ),
            actual = parser.parseSingleLineOfMultilineValue(start = 0, line = "abc123 \"\"\"", quote = '"').value
        )
        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc123 "
            ),
            actual = parser.parseSingleLineOfMultilineValue(start = 0, line = "abc123 '''", quote = '\'').value
        )

        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc123 "
            ),
            actual = parser.parseSingleLineOfMultilineValue(start = 0, line = "abc123 \"\"\"456", quote = '"').value
        )
        assertEquals(
            expected = IndexedString(
                index = 0,
                value = "abc123 "
            ),
            actual = parser.parseSingleLineOfMultilineValue(start = 0, line = "abc123 '''456", quote = '\'').value
        )
    }

    @Test
    fun interpolate_returns_same_value_for_empty_string() {
        val parser = DotEnvParser()

        parser.apply {
            assertEquals(expected = "", actual = "".interpolate())
        }
    }

    @Test
    fun interpolate_returns_same_value_for_blank_string() {
        val parser = DotEnvParser()

        parser.apply {
            assertEquals(expected = "   ", actual = "   ".interpolate())
        }
    }

    @Test
    fun interpolate_replaces_reference() {
        val parser = DotEnvParser()

        val values = mapOf(
            "one" to "abc",
            "v2" to "two"
        )

        parser.apply {
            assertEquals(expected = "abc", actual = "\${one}".interpolate(values = values))
            assertEquals(expected = "one, two, three", actual = "one, \${v2}, three".interpolate(values = values))
        }
    }

    @Test
    fun interpolate_throws_exception_for_reference_without_ending_bracket() {
        val parser = DotEnvParser()

        val values = mapOf(
            "one" to "abc",
            "v2" to "two"
        )

        parser.apply {
            assertEquals(expected = "abc", actual = "\${one}".interpolate(values = values))
            assertEquals(expected = "one, two, three", actual = "one, \${v2}, three".interpolate(values = values))
        }
    }

    @Test
    fun parse_multiline_value_throws_exception_for_start_less_than_zero() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseMultilineValue(start = -1, line = "abc123", quote = '"', reader = LineReaderSource("abc123"))
        }
    }

    @Test
    fun parse_multiline_value_throws_exception_for_start_greater_than_last_index() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseMultilineValue(start = 6, line = "abc123", quote = '"', reader = LineReaderSource("abc123"))
        }
    }

    @Test
    fun parse_multiline_string_continues_until_ending_quotation_mark_set() {
        val parser = DotEnvParser()
        val multiline = "\"\"\"One Line\nTwo Line\nThree Line\"\"\""
        val reader = LineReaderSource(multiline)
        reader.readLine() // Ignore the result, just start at the spot the parser would start at
        val lineOne = "\"\"\"One Line" // Will start after the starting quotation mark set
        val expectedResult = "One Line\nTwo Line\nThree Line"

        val result = parser.parseMultilineValue(
            start = 3,
            line = lineOne,
            quote = '"',
            reader = reader
        )

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun parse_value_throws_exception_for_start_less_than_zero() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseValue(start = -1, line = "abc123", reader = LineReaderSource("abc123"))
        }
    }

    @Test
    fun parse_value_throws_exception_for_start_greater_than_last_index() {
        val parser = DotEnvParser()

        assertFailsWith(IndexOutOfBoundsException::class) {
            parser.parseValue(start = 6, line = "abc123", reader = LineReaderSource("abc123"))
        }
    }

    @Test
    fun parse_value_empty_string_returns_null() {
        val parser = DotEnvParser()

        assertEquals(expected = null, actual = parser.parseValue(start = 0, line = "", reader = LineReaderSource("")))
    }

    @Test
    fun parse_value_blank_string_returns_null() {
        val parser = DotEnvParser()

        assertEquals(
            expected = null,
            actual = parser.parseValue(start = 0, line = "   ", reader = LineReaderSource("   "))
        )
    }

    @Test
    fun parse_value_returns_expected_results() {
        val parser = DotEnvParser()

        // Single Line
        assertEquals(
            expected = "abc",
            actual = parser.parseValue(start = 0, line = "\"abc\"", reader = LineReaderSource("abc"))
        )
        assertEquals(
            expected = "abc",
            actual = parser.parseValue(start = 0, line = "abc", reader = LineReaderSource("abc"))
        )

        // Multiline
        val multiline = "\"\"\"One Line\nTwo Line\nThree Line\"\"\""
        val reader = LineReaderSource(multiline)
        reader.readLine() // Ignore the result, just start at the spot the parser would start at
        val expectedResult = "One Line\nTwo Line\nThree Line"

        val result = parser.parseValue(
            start = 0,
            line = "\"\"\"One Line",
            reader = reader
        )

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun parse_returns_variables() {
        val parser = DotEnvParser()

        val string = """
                |export keyOne=valueOne
                |keyTwo = valueTwo
                | keyThree= "valueThree"
                |  keyFour ='valueFour'
                |# comment
            """.trimMargin()
        val expectedResult = listOf(
            EnvironmentVariable(
                key = "keyOne",
                stringValue = "valueOne"
            ),
            EnvironmentVariable(
                key = "keyTwo",
                stringValue = "valueTwo"
            ),
            EnvironmentVariable(
                key = "keyThree",
                stringValue = "valueThree"
            ),
            EnvironmentVariable(
                key = "keyFour",
                stringValue = "valueFour"
            )
        )
        val result = parser.parse(string)

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun parse_allow_empty_values_works() {
        val parser = DotEnvParser(
            options = DotEnvParser.Options(
                includeEmptyValues = true
            )
        )

        val string = """
                |export keyOne=valueOne
                |keyTwo = valueTwo
                | keyThree= "valueThree"
                |  keyFour ='valueFour'
                |keyFive
                |    keySix
                |# comment
            """.trimMargin()
        val expectedResult = listOf(
            EnvironmentVariable(
                key = "keyOne",
                stringValue = "valueOne"
            ),
            EnvironmentVariable(
                key = "keyTwo",
                stringValue = "valueTwo"
            ),
            EnvironmentVariable(
                key = "keyThree",
                stringValue = "valueThree"
            ),
            EnvironmentVariable(
                key = "keyFour",
                stringValue = "valueFour"
            ),
            EnvironmentVariable(
                key = "keyFive",
                stringValue = ""
            ),
            EnvironmentVariable(
                key = "keySix",
                stringValue = ""
            )
        )
        val result = parser.parse(string)

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun blank_separating_lines_are_ignored() {
        val parser = DotEnvParser(
            options = DotEnvParser.Options(
                includeEmptyValues = true
            )
        )

        val string = """
                |export keyOne=valueOne
                |
                |keyTwo = valueTwo
                |
                | keyThree= "valueThree"
                | 
                |  keyFour ='valueFour'
                |  
                |keyFive
                |
                |    keySix
                |    
                |# comment
            """.trimMargin()
        val expectedResult = listOf(
            EnvironmentVariable(
                key = "keyOne",
                stringValue = "valueOne"
            ),
            EnvironmentVariable(
                key = "keyTwo",
                stringValue = "valueTwo"
            ),
            EnvironmentVariable(
                key = "keyThree",
                stringValue = "valueThree"
            ),
            EnvironmentVariable(
                key = "keyFour",
                stringValue = "valueFour"
            ),
            EnvironmentVariable(
                key = "keyFive",
                stringValue = ""
            ),
            EnvironmentVariable(
                key = "keySix",
                stringValue = ""
            )
        )
        val result = parser.parse(string)

        assertEquals(expected = expectedResult, actual = result)
    }
}
