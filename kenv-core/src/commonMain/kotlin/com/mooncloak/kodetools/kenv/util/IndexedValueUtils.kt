package com.mooncloak.kodetools.kenv.util

typealias IndexedString = IndexedValue<String>

/**
 * Retrieves the starting point index of this [IndexedValue] within its parent sequence.
 *
 * This delegates to the [IndexedValue.index] property and is provided as a convenience since we access the values as
 * "start" and "end" values internally.
 */
internal val <T> IndexedValue<T>.start: Int
    inline get() = index

/**
 * Retrieves the end index (exclusive) of this [IndexedValue] within its parent sequence.
 */
internal val IndexedValue<CharSequence>.endExclusive: Int
    get() = index + value.length
