package com.mooncloak.kodetools.kenv

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class EnvironmentVariableValueTest {

    @Test
    fun toStringDoesNotOutputValue() {
        val value = EnvironmentVariable.Value(value = "secret")

        assertEquals(expected = "EnvValue(***)", actual = value.toString())
        assertFalse(actual = value.toString().contains("secret"))
    }

    @Test
    fun valueGivesExpectedResult() {
        val value = EnvironmentVariable.Value(value = "testing123")

        assertEquals(expected = "testing123", actual = value.value)
    }
}
