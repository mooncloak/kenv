package com.mooncloak.kodetools.kenv.util

import okio.FileSystem
import okio.WasiFileSystem

internal actual val FileSystem.Companion.platformDefault: FileSystem
    get() = WasiFileSystem
