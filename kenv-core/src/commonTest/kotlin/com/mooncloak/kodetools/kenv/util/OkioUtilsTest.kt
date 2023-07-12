package com.mooncloak.kodetools.kenv.util

import kotlin.test.Test
import kotlin.test.assertEquals

class OkioUtilsTest {

    @Test
    fun buffered_as_utf8_works_as_expected() {
        val string = "testing123"
        val source = string.bufferedAsUtf8()
        val result = source.readUtf8()

        assertEquals(expected = string, actual = result)
    }
}
