package com.mooncloak.kodetools.kenv

import kotlin.test.Test
import kotlin.test.assertEquals

class EnvironmentVariableTest {

    @Test
    fun component1ReturnsKey() {
        val variable = EnvironmentVariable(
            key = "test",
            value = EnvironmentVariable.Value(value = "value")
        )

        assertEquals(expected = "test", actual = variable.component1())
    }

    @Test
    fun component2ReturnsValue() {
        val variable = EnvironmentVariable(
            key = "test",
            value = EnvironmentVariable.Value(value = "value")
        )

        assertEquals(expected = EnvironmentVariable.Value(value = "value"), actual = variable.component2())
    }

    @Test
    fun secondaryConstructorFunctionReturnsExpectedResult() {
        val variable = EnvironmentVariable(
            key = "key",
            stringValue = "value"
        )
        val otherVariable = EnvironmentVariable(
            key = "key",
            value = EnvironmentVariable.Value(value = "value")
        )

        assertEquals(expected = "key", actual = variable.key)
        assertEquals(expected = EnvironmentVariable.Value(value = "value"), actual = variable.value)
        assertEquals(expected = "value", actual = variable.value.value)
        assertEquals(expected = otherVariable, actual = variable)
    }
}
