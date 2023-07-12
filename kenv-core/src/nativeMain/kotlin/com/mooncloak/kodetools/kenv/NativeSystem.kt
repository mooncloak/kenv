@file:Suppress("unused")

package com.mooncloak.kodetools.kenv

import com.mooncloak.kodetools.kenv.exception.NoSuchEnvironmentVariableException
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString
import platform.posix.getenv

@OptIn(ExperimentalForeignApi::class)
@Throws(NoSuchEnvironmentVariableException::class)
internal actual fun System.platformGetEnv(key: String): EnvironmentVariable.Value =
    getenv(key)?.toKString()?.let { EnvironmentVariable.Value(value = it) }
        ?: throw NoSuchEnvironmentVariableException(key = key)
