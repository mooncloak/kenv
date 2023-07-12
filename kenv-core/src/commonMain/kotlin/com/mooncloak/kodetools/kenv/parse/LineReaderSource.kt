package com.mooncloak.kodetools.kenv.parse

import com.mooncloak.kodetools.kenv.util.bufferedAsUtf8
import okio.Buffer
import okio.Source
import okio.Timeout
import okio.buffer

/**
 * A component that reads UTF-8 lines from a [Source].
 *
 * Note that this will buffer the source into memory.
 */
internal class LineReaderSource(source: Source) : Source {

    constructor(utf8String: String) : this(source = utf8String.bufferedAsUtf8())

    private val bufferedSource = source.buffer()

    override fun close() = bufferedSource.close()

    override fun read(sink: Buffer, byteCount: Long): Long =
        bufferedSource.read(sink = sink, byteCount = byteCount)

    override fun timeout(): Timeout = bufferedSource.timeout()

    fun readLine(): String? =
        bufferedSource.readUtf8Line()

    fun readLines(): List<String> {
        val lines = mutableListOf<String>()
        var line = readLine()

        while (line != null) {
            lines.add(line)
            line = readLine()
        }

        return lines
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LineReaderSource) return false

        return bufferedSource == other.bufferedSource
    }

    override fun hashCode(): Int = bufferedSource.hashCode()

    override fun toString(): String = "LineReaderSource(bufferedSource=$bufferedSource)"
}
