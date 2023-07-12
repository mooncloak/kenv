package com.mooncloak.kodetools.kenv.util

import kotlin.test.Test
import kotlin.test.assertEquals

class IndexedValueUtilsTest {

    @Test
    fun start_delegates_to_index() {
        val value = IndexedValue(index = 5, value = "test")

        assertEquals(expected = 5, actual = value.index)
        assertEquals(expected = 5, actual = value.start)
        assertEquals(expected = value.index, actual = value.start)
    }

    @Test
    fun end_exclusive_is_correct() {
        val valueOne = IndexedValue(index = 0, value = "")
        val valueTwo = IndexedValue(index = 5, value = "test")

        assertEquals(expected = 0, actual = valueOne.index)
        assertEquals(expected = 0, actual = valueOne.value.length)
        assertEquals(expected = 0, actual = valueOne.endExclusive)
        assertEquals(expected = 5, actual = valueTwo.index)
        assertEquals(expected = 4, actual = valueTwo.value.length)
        assertEquals(expected = 9, actual = valueTwo.endExclusive)
    }
}
