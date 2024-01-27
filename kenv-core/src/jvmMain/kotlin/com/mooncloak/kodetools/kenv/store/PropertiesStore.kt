package com.mooncloak.kodetools.kenv.store

import com.mooncloak.kodetools.kenv.EnvironmentVariable
import java.util.Properties

/**
 * An [EnvironmentVariableStore] implementation that wraps Java [Properties].
 */
internal class PropertiesStore internal constructor(
    private val properties: Properties
) : EnvironmentVariableStore {

    override fun get(key: String): EnvironmentVariable.Value {
        val value = properties.getProperty(key)

        return EnvironmentVariable.Value(value = value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PropertiesStore) return false

        return properties == other.properties
    }

    override fun hashCode(): Int =
        properties.hashCode()

    override fun toString(): String =
        "PropertiesStore(properties=$properties)"
}
