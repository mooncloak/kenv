@file:Suppress("unused")

package com.mooncloak.kodetools.kenv.store

import com.mooncloak.kodetools.kenv.EnvironmentVariable
import com.mooncloak.kodetools.kenv.exception.NoSuchEnvironmentVariableException

/**
 * An [EnvironmentVariableStore] that stores the [EnvironmentVariable]s in an in-memory [Map].
 */
internal class InMemoryEnvironmentVariableStore : EnvironmentVariableStore {

    private val variables: Map<String, EnvironmentVariable.Value>

    constructor(variables: Map<String, EnvironmentVariable.Value>) {
        this.variables = variables.toMap()
    }

    constructor(variables: Collection<EnvironmentVariable>) {
        this.variables = variables.associate { it.key to it.value }
    }

    constructor(vararg variables: EnvironmentVariable) {
        this.variables = variables.associate { it.key to it.value }
    }

    override fun get(key: String): EnvironmentVariable.Value =
        variables.get(key = key)
            ?: throw NoSuchEnvironmentVariableException(key = key)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is InMemoryEnvironmentVariableStore) return false

        return variables == other.variables
    }

    override fun hashCode(): Int =
        variables.hashCode()

    override fun toString(): String =
        "InMemoryEnvironmentVariableStore(variables=$variables)"
}
