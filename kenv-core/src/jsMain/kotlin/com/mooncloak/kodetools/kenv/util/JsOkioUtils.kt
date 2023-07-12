@file:Suppress("unused")

package com.mooncloak.kodetools.kenv.util

import okio.FileSystem
import okio.NodeJsFileSystem

internal actual val FileSystem.Companion.platformDefault: FileSystem
    get() = NodeJsFileSystem
