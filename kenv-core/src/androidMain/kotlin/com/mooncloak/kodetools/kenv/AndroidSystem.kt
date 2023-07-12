@file:Suppress("unused")

package com.mooncloak.kodetools.kenv

import com.mooncloak.kodetools.kenv.exception.NoSuchEnvironmentVariableException

@Throws(NoSuchEnvironmentVariableException::class)
internal actual fun System.platformGetEnv(key: String): EnvironmentVariable.Value =
    java.lang.System.getenv(key)?.let { EnvironmentVariable.Value(value = it) }
        ?: throw NoSuchEnvironmentVariableException(key = key)
