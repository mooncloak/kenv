@file:Suppress("unused")

package com.mooncloak.kodetools.kenv

import com.mooncloak.kodetools.kenv.store.*
import com.mooncloak.kodetools.kenv.store.CascadingEnvironmentVariableStore

/**
 * Represents a Kotlin multi-platform container of [EnvironmentVariable]s. The way in which this instance was
 * constructed determines how the [EnvironmentVariable]s will be retrieved. Every [Kenv] instance will check the
 * [System] environment variables via [System.platformGetEnv], if no other [EnvironmentVariableStore] contains a
 * matching [EnvironmentVariable] with the same key.
 *
 * To construct an instance of this class, use the [Kenv] constructor function.
 */
class Kenv internal constructor(stores: Collection<EnvironmentVariableStore>) : EnvironmentVariableStore {

    private val delegate: EnvironmentVariableStore = CascadingEnvironmentVariableStore(
        stores = stores
    )

    override fun get(key: String): EnvironmentVariable.Value = delegate.get(key = key)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Kenv) return false

        return delegate == other.delegate
    }

    override fun hashCode(): Int = delegate.hashCode()

    override fun toString(): String = "Kenv(delegate=$delegate)"

    companion object
}
