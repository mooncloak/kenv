package com.mooncloak.kodetools.kenv

internal actual fun System.platformGetEnv(key: String): EnvironmentVariable.Value =
    throw UnsupportedOperationException("WASM WASI does not currently have a `System` implementation to retrieve environment variables.")
