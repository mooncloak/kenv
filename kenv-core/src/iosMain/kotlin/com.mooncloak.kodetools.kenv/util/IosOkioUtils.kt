@file:Suppress("unused")

package com.mooncloak.kodetools.kenv.util

import okio.FileSystem

internal actual val FileSystem.Companion.platformDefault: FileSystem
    get() = SYSTEM
