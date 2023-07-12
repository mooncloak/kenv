package com.mooncloak.kodetools.kenv.util

/**
 * Returns index of the first character matching the given [predicate] beginning at the provided [start] index and
 * ending at the provided [endExclusive] index, or -1 if the char sequence does not contain such character.
 *
 * @throws [IndexOutOfBoundsException] if the provided [start] and [endExclusive] index values are out of bounds for
 * this [CharSequence].
 */
internal inline fun CharSequence.indexOfFirst(
    start: Int = 0,
    endExclusive: Int = this.length,
    predicate: (Char) -> Boolean
): Int {
    if (start < 0) throw IndexOutOfBoundsException("'start' index must be greater than or equal to zero. start = $start")
    if (start >= endExclusive) throw IndexOutOfBoundsException("'start' index must be less than 'line.length'. start = $start")
    if (endExclusive > this.length) throw IndexOutOfBoundsException("'endExclusive' index must be less than or equal to the CharSequence 'length'. endExclusive = $endExclusive")

    var index = start

    while (index < endExclusive) {
        if (predicate(this[index])) {
            return index
        }

        index++
    }

    return -1
}
