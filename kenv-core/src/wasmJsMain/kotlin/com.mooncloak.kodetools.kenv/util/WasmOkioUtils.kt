package com.mooncloak.kodetools.kenv.util

import okio.FileSystem

internal actual val FileSystem.Companion.platformDefault: FileSystem
    get() = throw UnsupportedOperationException("WASM does not currently have a platform default `FileSystem`. If targeting WASI, you can use okio's wasifilesystem dependency to obtain a `FileSystem` instance.")
