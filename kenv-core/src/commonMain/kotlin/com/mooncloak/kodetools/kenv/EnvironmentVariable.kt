package com.mooncloak.kodetools.kenv

import kotlin.jvm.JvmInline

class EnvironmentVariable(
    val key: String,
    val value: Value
) {

    operator fun component1(): String = key

    operator fun component2(): Value = value

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EnvironmentVariable) return false

        if (key != other.key) return false

        return value == other.value
    }

    override fun hashCode(): Int {
        var result = key.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }

    override fun toString(): String =
        "EnvironmentVariable(key='$key', value=$value)"

    /**
     * Represents the value of an [EnvironmentVariable].
     */
    @JvmInline
    value class Value(
        val value: String
    ) {

        // Deliberately mask the value to prevent accidental leaking of the value, for instance in logs. The value can
        // still be obtained explicitly and converted to a String if desired.
        override fun toString(): String = "EnvValue(***)"
    }
}

/**
 * Constructs an [EnvironmentVariable] instance with the provided [String] [key] and [stringValue].
 */
fun EnvironmentVariable(
    key: String,
    stringValue: String
): EnvironmentVariable = EnvironmentVariable(
    key = key,
    value = EnvironmentVariable.Value(value = stringValue)
)
