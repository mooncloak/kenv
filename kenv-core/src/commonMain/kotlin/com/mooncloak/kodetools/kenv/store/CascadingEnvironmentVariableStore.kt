@file:Suppress("unused")

package com.mooncloak.kodetools.kenv.store

import com.mooncloak.kodetools.kenv.EnvironmentVariable
import com.mooncloak.kodetools.kenv.exception.NoSuchEnvironmentVariableException

/**
 * An [EnvironmentVariableStore] implementation that delegates to a [Collection] of provided
 * [EnvironmentVariableStore]s, first checking the last [EnvironmentVariableStore] for an associated value, and
 * iterating through the collection backwards until it finds the associated value for a key.
 */
internal class CascadingEnvironmentVariableStore : EnvironmentVariableStore {

    private val stores: List<EnvironmentVariableStore>

    constructor(stores: Collection<EnvironmentVariableStore>) {
        this.stores = stores.toList().reversed()
    }

    constructor(vararg stores: EnvironmentVariableStore) {
        this.stores = stores.toList().reversed()
    }

    override fun get(key: String): EnvironmentVariable.Value =
        stores.firstNotNullOfOrNull { it.getOrNull(key = key) }
            ?: throw NoSuchEnvironmentVariableException(key = key)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CascadingEnvironmentVariableStore) return false

        return stores == other.stores
    }

    override fun hashCode(): Int = stores.hashCode()

    override fun toString(): String = "CascadingEnvironmentVariableStore(stores=$stores)"
}
