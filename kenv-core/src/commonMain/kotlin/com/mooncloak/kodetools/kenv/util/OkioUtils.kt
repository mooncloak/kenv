package com.mooncloak.kodetools.kenv.util

import okio.Buffer
import okio.BufferedSource
import okio.FileSystem

/**
 * Converts this [String] value into a [BufferedSource].
 */
internal fun String.bufferedAsUtf8(): BufferedSource {
    val buffer = Buffer()

    buffer.writeUtf8(this)

    return buffer
}

/**
 * Retrieves the default platform [FileSystem] instance.
 */
internal expect val FileSystem.Companion.platformDefault: FileSystem
