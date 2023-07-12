@file:Suppress("unused")

package com.mooncloak.kodetools.kenv.store

import com.mooncloak.kodetools.kenv.EnvironmentVariable
import com.mooncloak.kodetools.kenv.Kenv
import com.mooncloak.kodetools.kenv.System
import com.mooncloak.kodetools.kenv.exception.NoSuchEnvironmentVariableException

/**
 * A component that handles the retrieving of environment variables. An implementation of this interface can wrap a
 * data store of environment variables or serve as an abstraction for an already existing environment variable
 * location, such as [System] environment variables.
 */
interface EnvironmentVariableStore {

    /**
     * Determines whether an environment variable exists with the provided [key] within this [EnvironmentVariableStore]
     * instance.
     *
     * @return `true` if there is an environment variable in this [EnvironmentVariableStore] with the provided [key],
     * otherwise `false`.
     */
    operator fun contains(key: String): Boolean =
        getOrNull(key = key) != null

    /**
     * Retrieves an environment variable value from this [EnvironmentVariableStore] instance for the provided [key], or
     * throws a [NoSuchEnvironmentVariableException] if no environment variable exists for that key.
     *
     * @param [key] The name of the environment variable whose value is being retrieved.
     *
     * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this
     * [EnvironmentVariableStore] instance with the provided [key].
     *
     * @return The [EnvironmentVariable.Value] corresponding to the environment variable in this
     * [EnvironmentVariableStore] instance with the provided [key].
     */
    operator fun get(key: String): EnvironmentVariable.Value

    /**
     * Retrieves an environment variable from this [EnvironmentVariableStore] instance for the provided [key], or
     * throws a [NoSuchEnvironmentVariableException] if no environment variable exists for that key.
     *
     * @param [key] The name of the environment variable whose value is being retrieved.
     *
     * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this
     * [EnvironmentVariableStore] instance with the provided [key].
     *
     * @return The [EnvironmentVariable] corresponding to the environment variable in this [EnvironmentVariableStore]
     * instance with the provided [key].
     */
    fun getVariable(key: String): EnvironmentVariable {
        val value = get(key = key)

        return EnvironmentVariable(key = key, value = value)
    }
}

/**
 * Retrieves an environment variable value from this [EnvironmentVariableStore] instance for the provided [key], or
 * `null` if no environment variable exists for that key.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @return The [EnvironmentVariable.Value] corresponding to the environment variable in this
 * [EnvironmentVariableStore] instance with the provided [key], or `null` if there is no value for the provided [key].
 */
fun EnvironmentVariableStore.getOrNull(key: String): EnvironmentVariable.Value? =
    try {
        get(key = key)
    } catch (_: NoSuchEnvironmentVariableException) {
        null
    }

/**
 * Retrieves an environment variable value from this [EnvironmentVariableStore] instance for the provided [key], or
 * the [defaultValue] if no environment variable exists for that key.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @return The [EnvironmentVariable.Value] corresponding to the environment variable in this
 * [EnvironmentVariableStore] instance with the provided [key], or the provided [defaultValue] if there is no value for
 * the provided [key].
 */
fun EnvironmentVariableStore.getOrDefault(
    key: String,
    defaultValue: EnvironmentVariable.Value
): EnvironmentVariable.Value =
    getOrNull(key = key) ?: defaultValue

/**
 * A convenience function for invoking the [EnvironmentVariableStore.get] function.
 *
 * @see [EnvironmentVariableStore.get]
 */
@Throws(NoSuchEnvironmentVariableException::class)
inline fun EnvironmentVariableStore.getEnv(key: String): EnvironmentVariable.Value = get(key = key)

/**
 * A convenience function for invoking the [EnvironmentVariableStore.getOrNull] function.
 *
 * @see [EnvironmentVariableStore.getOrNull]
 */
inline fun EnvironmentVariableStore.getEnvOrNull(key: String): EnvironmentVariable.Value? =
    getOrNull(key = key)

/**
 * A convenience function for invoking the [EnvironmentVariableStore.getOrDefault] function.
 *
 * @see [EnvironmentVariableStore.getOrDefault]
 */
inline fun EnvironmentVariableStore.getEnvOrDefault(
    key: String,
    defaultValue: EnvironmentVariable.Value
): EnvironmentVariable.Value =
    getOrDefault(key = key, defaultValue = defaultValue)

/**
 * Retrieves an environment variable from this [EnvironmentVariableStore] instance for the provided [key], or `null` if
 * no environment variable exists for that key.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @return The [EnvironmentVariable] corresponding to the environment variable in this [EnvironmentVariableStore]
 * instance with the provided [key], or `null` if there is no value for the provided [key].
 */
fun EnvironmentVariableStore.getVariableOrNull(key: String): EnvironmentVariable? =
    try {
        getVariable(key = key)
    } catch (_: NoSuchEnvironmentVariableException) {
        null
    }

/**
 * Retrieves an environment variable from this [EnvironmentVariableStore] instance for the provided [key], or
 * [defaultValue] if no environment variable exists for that key.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @return The [EnvironmentVariable] corresponding to the environment variable in this [EnvironmentVariableStore]
 * instance with the provided [key], or the provided [defaultValue] if there is no value for the provided [key].
 */
fun EnvironmentVariableStore.getVariableOrDefault(
    key: String,
    defaultValue: EnvironmentVariable.Value
): EnvironmentVariable =
    getVariableOrNull(key = key) ?: EnvironmentVariable(key = key, value = defaultValue)

