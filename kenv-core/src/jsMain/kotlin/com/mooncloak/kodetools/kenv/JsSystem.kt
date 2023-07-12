@file:Suppress("unused")

package com.mooncloak.kodetools.kenv

import com.mooncloak.kodetools.kenv.exception.NoSuchEnvironmentVariableException

internal external interface Process {

    val env: dynamic
}

internal external val process: Process

internal actual fun System.platformGetEnv(key: String): EnvironmentVariable.Value =
    try {
        process.env[key].unsafeCast<String>().let { EnvironmentVariable.Value(value = it) }
    } catch (e: Exception) {
        throw NoSuchEnvironmentVariableException(
            message = "No environment variable found in 'System' for '$key'.",
            cause = e
        )
    }
