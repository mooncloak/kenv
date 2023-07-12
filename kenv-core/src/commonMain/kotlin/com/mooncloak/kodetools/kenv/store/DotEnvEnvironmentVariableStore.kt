package com.mooncloak.kodetools.kenv.store

import com.mooncloak.kodetools.kenv.EnvironmentVariable
import com.mooncloak.kodetools.kenv.exception.NoSuchEnvironmentVariableException
import com.mooncloak.kodetools.kenv.parse.DotEnvParser
import com.mooncloak.kodetools.kenv.parse.LineReaderSource
import okio.Source

/**
 * An [EnvironmentVariableStore] implementation that reads all the environment variables from the provided [Source] on
 * first load of a value.
 */
internal class DotEnvEnvironmentVariableStore(
    source: Source,
    options: DotEnvParser.Options = DotEnvParser.Options()
) : EnvironmentVariableStore {

    private val lineReader = LineReaderSource(source = source)
    private val parser = DotEnvParser(options = options)
    private val variables = mutableMapOf<String, EnvironmentVariable.Value>()
    private var isParsed = false

    override fun get(key: String): EnvironmentVariable.Value {
        if (!isParsed) {
            loadVariables()
        }

        return variables[key] ?: throw NoSuchEnvironmentVariableException(key = key)
    }

    private fun loadVariables() {
        isParsed = true

        parser.parse(reader = lineReader).forEach { variable ->
            variables[variable.key] = variable.value
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DotEnvEnvironmentVariableStore) return false

        if (lineReader != other.lineReader) return false
        if (parser != other.parser) return false
        if (variables != other.variables) return false

        return isParsed == other.isParsed
    }

    override fun hashCode(): Int {
        var result = lineReader.hashCode()
        result = 31 * result + parser.hashCode()
        result = 31 * result + variables.hashCode()
        result = 31 * result + isParsed.hashCode()
        return result
    }

    override fun toString(): String =
        "DotEnvEnvironmentVariableStore(" +
                "lineReader=$lineReader, " +
                "parser=$parser, " +
                "variables=$variables, " +
                "isParsed=$isParsed)"
}
