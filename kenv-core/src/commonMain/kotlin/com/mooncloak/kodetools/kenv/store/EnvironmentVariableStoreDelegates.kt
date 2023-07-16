@file:Suppress("unused")

package com.mooncloak.kodetools.kenv.store

import com.mooncloak.kodetools.kenv.*
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [String], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.boolean(
    key: String? = null,
    defaultValue: String
): ReadOnlyProperty<Any?, String> =
    StringDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Boolean], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.boolean(
    key: String? = null,
    defaultValue: Boolean = false
): ReadOnlyProperty<Any?, Boolean> =
    BooleanDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Byte], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.byte(key: String? = null, defaultValue: Byte = 0): ReadOnlyProperty<Any?, Byte> =
    ByteDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Short], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.short(key: String? = null, defaultValue: Short = 0): ReadOnlyProperty<Any?, Short> =
    ShortDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Int], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.int(key: String? = null, defaultValue: Int = 0): ReadOnlyProperty<Any?, Int> =
    IntDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Long], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.long(key: String? = null, defaultValue: Long = 0L): ReadOnlyProperty<Any?, Long> =
    LongDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Float], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.float(key: String? = null, defaultValue: Float = 0f): ReadOnlyProperty<Any?, Float> =
    FloatDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Int], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.double(key: String? = null, defaultValue: Double = 0.0): ReadOnlyProperty<Any?, Double> =
    DoubleDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [UByte], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.ubyte(key: String? = null, defaultValue: UByte = 0u): ReadOnlyProperty<Any?, UByte> =
    UByteDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [UShort], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.ushort(key: String? = null, defaultValue: UShort = 0u): ReadOnlyProperty<Any?, UShort> =
    UShortDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [UInt], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.uint(key: String? = null, defaultValue: UInt = 0u): ReadOnlyProperty<Any?, UInt> =
    UIntDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [ULong], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then the `defaultValue` is used.
 */
fun EnvironmentVariableStore.ulong(key: String? = null, defaultValue: ULong = 0u): ReadOnlyProperty<Any?, ULong> =
    ULongDelegate(store = this, key = key, defaultValue = defaultValue)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [String], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.stringOrNull(
    key: String? = null
): ReadOnlyProperty<Any?, String?> =
    NullableStringDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Boolean], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.booleanOrNull(
    key: String? = null
): ReadOnlyProperty<Any?, Boolean?> =
    NullableBooleanDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Byte], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.byteOrNull(key: String? = null): ReadOnlyProperty<Any?, Byte?> =
    NullableByteDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Short], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.shortOrNull(key: String? = null): ReadOnlyProperty<Any?, Short?> =
    NullableShortDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Int], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.intOrNull(key: String? = null): ReadOnlyProperty<Any?, Int?> =
    NullableIntDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Long], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.longOrNull(key: String? = null): ReadOnlyProperty<Any?, Long?> =
    NullableLongDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Float], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.floatOrNull(key: String? = null): ReadOnlyProperty<Any?, Float?> =
    NullableFloatDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [Int], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.doubleOrNull(key: String? = null): ReadOnlyProperty<Any?, Double?> =
    NullableDoubleDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [UByte], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.ubyteOrNull(key: String? = null): ReadOnlyProperty<Any?, UByte?> =
    NullableUByteDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [UShort], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.ushortOrNull(key: String? = null): ReadOnlyProperty<Any?, UShort?> =
    NullableUShortDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [UInt], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.uintOrNull(key: String? = null): ReadOnlyProperty<Any?, UInt?> =
    NullableUIntDelegate(store = this, key = key)

/**
 * Retrieves a property delegate representing an [EnvironmentVariable.Value], converted to an [ULong], retrieved from
 * this [EnvironmentVariableStore] using the provided [key] (or the name of the delegated variable if the [key] is
 * `null`), or if there is no matching [EnvironmentVariable.Value] for the [key] then `null` is returned.
 */
fun EnvironmentVariableStore.ulongOrNull(key: String? = null): ReadOnlyProperty<Any?, ULong?> =
    NullableULongDelegate(store = this, key = key)

/**
 * An abstract [ReadOnlyProperty] that coordinates its [getValue] function via a [String] key. If the [key] is `null`,
 * then [KProperty.name] will be used as a default.
 */
private abstract class OptionalKeyDelegate<T>(
    private val key: String?
) : ReadOnlyProperty<Any?, T> {

    abstract fun getValue(key: String): T

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = getValue(key ?: property.name)
}

private class StringDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: String
) : OptionalKeyDelegate<String>(key) {

    override fun getValue(key: String): String = store.getStringOrDefault(key = key, defaultValue = defaultValue)
}

private class BooleanDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: Boolean
) : OptionalKeyDelegate<Boolean>(key) {

    override fun getValue(key: String): Boolean = store.getBooleanOrDefault(key = key, defaultValue = defaultValue)
}

private class ByteDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: Byte
) : OptionalKeyDelegate<Byte>(key) {

    override fun getValue(key: String): Byte = store.getByteOrDefault(key = key, defaultValue = defaultValue)
}

private class ShortDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: Short
) : OptionalKeyDelegate<Short>(key) {

    override fun getValue(key: String): Short = store.getShortOrDefault(key = key, defaultValue = defaultValue)
}

private class IntDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: Int
) : OptionalKeyDelegate<Int>(key) {

    override fun getValue(key: String): Int = store.getIntOrDefault(key = key, defaultValue = defaultValue)
}

private class LongDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: Long
) : OptionalKeyDelegate<Long>(key) {

    override fun getValue(key: String): Long = store.getLongOrDefault(key = key, defaultValue = defaultValue)
}

private class FloatDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: Float
) : OptionalKeyDelegate<Float>(key) {

    override fun getValue(key: String): Float = store.getFloatOrDefault(key = key, defaultValue = defaultValue)
}

private class DoubleDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: Double
) : OptionalKeyDelegate<Double>(key) {

    override fun getValue(key: String): Double = store.getDoubleOrDefault(key = key, defaultValue = defaultValue)
}

private class UByteDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: UByte
) : OptionalKeyDelegate<UByte>(key) {

    override fun getValue(key: String): UByte = store.getUByteOrDefault(key = key, defaultValue = defaultValue)
}

private class UShortDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: UShort
) : OptionalKeyDelegate<UShort>(key) {

    override fun getValue(key: String): UShort = store.getUShortOrDefault(key = key, defaultValue = defaultValue)
}

private class UIntDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: UInt
) : OptionalKeyDelegate<UInt>(key) {

    override fun getValue(key: String): UInt = store.getUIntOrDefault(key = key, defaultValue = defaultValue)
}

private class ULongDelegate(
    private val store: EnvironmentVariableStore,
    key: String?,
    private val defaultValue: ULong
) : OptionalKeyDelegate<ULong>(key) {

    override fun getValue(key: String): ULong = store.getULongOrDefault(key = key, defaultValue = defaultValue)
}

private class NullableStringDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<String?>(key) {

    override fun getValue(key: String): String? = store.getStringOrNull(key = key)
}

private class NullableBooleanDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<Boolean?>(key) {

    override fun getValue(key: String): Boolean? = store.getBooleanOrNull(key = key)
}

private class NullableByteDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<Byte?>(key) {

    override fun getValue(key: String): Byte? = store.getByteOrNull(key = key)
}

private class NullableShortDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<Short?>(key) {

    override fun getValue(key: String): Short? = store.getShortOrNull(key = key)
}

private class NullableIntDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<Int?>(key) {

    override fun getValue(key: String): Int? = store.getIntOrNull(key = key)
}

private class NullableLongDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<Long?>(key) {

    override fun getValue(key: String): Long? = store.getLongOrNull(key = key)
}

private class NullableFloatDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<Float?>(key) {

    override fun getValue(key: String): Float? = store.getFloatOrNull(key = key)
}

private class NullableDoubleDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<Double?>(key) {

    override fun getValue(key: String): Double? = store.getDoubleOrNull(key = key)
}

private class NullableUByteDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<UByte?>(key) {

    override fun getValue(key: String): UByte? = store.getUByteOrNull(key = key)
}

private class NullableUShortDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<UShort?>(key) {

    override fun getValue(key: String): UShort? = store.getUShortOrNull(key = key)
}

private class NullableUIntDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<UInt?>(key) {

    override fun getValue(key: String): UInt? = store.getUIntOrNull(key = key)
}

private class NullableULongDelegate(
    private val store: EnvironmentVariableStore,
    key: String?
) : OptionalKeyDelegate<ULong?>(key) {

    override fun getValue(key: String): ULong? = store.getULongOrNull(key = key)
}
