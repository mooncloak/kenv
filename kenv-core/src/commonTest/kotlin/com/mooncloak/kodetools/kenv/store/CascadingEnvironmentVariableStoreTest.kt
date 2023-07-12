package com.mooncloak.kodetools.kenv.store

import com.mooncloak.kodetools.kenv.EnvironmentVariable
import kotlin.test.Test
import kotlin.test.assertEquals

class CascadingEnvironmentVariableStoreTest {

    @Test
    fun variables_are_retrieved_from_stores_in_reverse_order() {
        val storeOne = InMemoryEnvironmentVariableStore(EnvironmentVariable(key = "keyOne", stringValue = "valueOne"))
        val storeTwo = InMemoryEnvironmentVariableStore(EnvironmentVariable(key = "keyOne", stringValue = "valueTwo"))
        val cascadingStore = CascadingEnvironmentVariableStore(storeOne, storeTwo)

        assertEquals(expected = "valueOne", actual = storeOne.get(key = "keyOne").value)
        assertEquals(expected = "valueTwo", actual = storeTwo.get(key = "keyOne").value)
        assertEquals(expected = "valueTwo", actual = cascadingStore.get(key = "keyOne").value)
    }

    @Test
    fun variables_defined_in_any_store_are_retrieved() {
        val storeOne = InMemoryEnvironmentVariableStore(EnvironmentVariable(key = "keyOne", stringValue = "valueOne"))
        val storeTwo = InMemoryEnvironmentVariableStore(EnvironmentVariable(key = "keyTwo", stringValue = "valueTwo"))
        val storeThree =
            InMemoryEnvironmentVariableStore(EnvironmentVariable(key = "keyThree", stringValue = "valueThree"))
        val cascadingStore = CascadingEnvironmentVariableStore(storeOne, storeTwo, storeThree)

        assertEquals(expected = "valueOne", actual = storeOne.get(key = "keyOne").value)
        assertEquals(expected = "valueTwo", actual = storeTwo.get(key = "keyTwo").value)
        assertEquals(expected = "valueThree", actual = storeThree.get(key = "keyThree").value)
        assertEquals(expected = "valueOne", actual = cascadingStore.get(key = "keyOne").value)
        assertEquals(expected = "valueTwo", actual = cascadingStore.get(key = "keyTwo").value)
        assertEquals(expected = "valueThree", actual = cascadingStore.get(key = "keyThree").value)
    }
}
