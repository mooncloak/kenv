package com.mooncloak.kodetools.kenv

import com.mooncloak.kodetools.kenv.exception.NoSuchEnvironmentVariableException

internal external interface Process {

    val env: Environment
}

internal external val process: Process

internal external interface Environment {

    operator fun get(key: String): String
}

internal actual fun System.platformGetEnv(key: String): EnvironmentVariable.Value =
    try {
        process.env[key].let { EnvironmentVariable.Value(value = it) }
    } catch (e: Exception) {
        throw NoSuchEnvironmentVariableException(
            message = "No environment variable found in 'System' for '$key'.",
            cause = e
        )
    }
