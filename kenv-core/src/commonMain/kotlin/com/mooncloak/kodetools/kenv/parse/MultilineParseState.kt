package com.mooncloak.kodetools.kenv.parse

import com.mooncloak.kodetools.kenv.util.IndexedString

/**
 * Represents the parsing state for the parsing of a multiline environment variable value. Each line is parsed
 * individually, therefore it is needed to know whether we are finished parsing (reached the ending quotation mark set),
 * or whether we need to continue parsing the next line. This class encapsulates that state.
 */
internal sealed class MultilineParseState private constructor() {

    abstract val value: IndexedString

    internal class InProgress(override val value: IndexedString) : MultilineParseState() {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is InProgress) return false

            return value == other.value
        }

        override fun hashCode(): Int = value.hashCode()

        override fun toString(): String = "InProgress(value=$value)"
    }

    internal class Finished(override val value: IndexedString) : MultilineParseState() {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Finished) return false

            return value == other.value
        }

        override fun hashCode(): Int = value.hashCode()

        override fun toString(): String = "Finished(value=$value)"
    }
}

/**
 * A convenience property to determine whether this [MultilineParseState] is a [MultilineParseState.Finished] instance.
 */
internal val MultilineParseState.isFinished: Boolean
    get() = this is MultilineParseState.Finished
