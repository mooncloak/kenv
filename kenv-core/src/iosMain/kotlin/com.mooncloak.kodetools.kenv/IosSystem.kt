@file:Suppress("unused")

package com.mooncloak.kodetools.kenv

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString
import platform.posix.getenv

@OptIn(ExperimentalForeignApi::class)
@Throws(NoSuchEnvironmentVariableException::class)
internal actual fun System.getEnv(key: String): EnvironmentVariable.Value =
    getenv(key)?.toKString()?.let { EnvironmentVariable.Value(value = it) }
        ?: throw NoSuchEnvironmentVariableException(key = key)
