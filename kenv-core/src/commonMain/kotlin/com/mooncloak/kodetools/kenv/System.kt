@file:Suppress("unused")

package com.mooncloak.kodetools.kenv

import com.mooncloak.kodetools.kenv.exception.NoSuchEnvironmentVariableException
import com.mooncloak.kodetools.kenv.store.EnvironmentVariableStore

/**
 * An [EnvironmentVariableStore] component that contains retrieves environment variables from the current platform.
 */
sealed interface System : EnvironmentVariableStore {

    override fun get(key: String): EnvironmentVariable.Value =
        platformGetEnv(key = key)

    companion object : System
}

/**
 * Retrieves an environment variable value from the current [System] for the provided [key], or throws a
 * [NoSuchEnvironmentVariableException] if no environment variable exists for that key.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in the current [System] with the
 * provided [key].
 *
 * @return The [EnvironmentVariable.Value] corresponding to the environment variable in the system with the provided
 * [key].
 */
@Throws(NoSuchEnvironmentVariableException::class)
internal expect fun System.platformGetEnv(key: String): EnvironmentVariable.Value

/**
 * Retrieves an environment variable value from the current [System] for the provided [key], or `null` if no
 * environment variable exists for that key.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @return The [EnvironmentVariable.Value] corresponding to the environment variable in the system with the provided
 * [key].
 */
fun System.getEnvOrNull(key: String): EnvironmentVariable.Value? =
    try {
        platformGetEnv(key = key)
    } catch (_: NoSuchEnvironmentVariableException) {
        null
    }
