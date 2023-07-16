@file:Suppress("unused")

package com.mooncloak.kodetools.kenv.store

import com.mooncloak.kodetools.kenv.EnvironmentVariable
import com.mooncloak.kodetools.kenv.exception.NoSuchEnvironmentVariableException

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then returns the
 * [EnvironmentVariable.Value.value] [String].
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @return The [String] value corresponding to the environment variable in this [EnvironmentVariableStore] identified
 * by the provided [key].
 */
fun EnvironmentVariableStore.getString(
    key: String
): String = get(key = key).value

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and returns the
 * [EnvironmentVariable.Value.value] [String].
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @return The [String] value corresponding to the environment variable in this [EnvironmentVariableStore] identified
 * by the provided [key], or `null` if it isn't present.
 */
fun EnvironmentVariableStore.getStringOrNull(
    key: String
): String? = getOrNull(key = key)?.value

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and returns the
 * [EnvironmentVariable.Value.value] [String] or the provided [defaultValue] if the key does not exist.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @return The [String] value corresponding to the environment variable in this [EnvironmentVariableStore] identified
 * by the provided [key], or the [defaultValue] if it isn't present.
 */
fun EnvironmentVariableStore.getStringOrDefault(
    key: String,
    defaultValue: String
): String = getOrNull(key = key)?.value ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Boolean] and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @return The [Boolean] value corresponding to the environment variable in this [EnvironmentVariableStore] identified
 * by the provided [key].
 *
 * @see [String.toBoolean]
 */
fun EnvironmentVariableStore.getBoolean(
    key: String
): Boolean = get(key = key).value.toBoolean()

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Boolean] and returns the result or `null` if the [String] value
 * is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @see [String.toBooleanStrictOrNull]
 */
fun EnvironmentVariableStore.getBooleanOrNull(
    key: String
): Boolean? = getOrNull(key = key)?.value?.toBooleanStrictOrNull()

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Boolean] and returns the result or the provided [defaultValue]
 * if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @see [String.toBooleanStrictOrNull]
 */
fun EnvironmentVariableStore.getBooleanOrDefault(
    key: String,
    defaultValue: Boolean
): Boolean = getOrNull(key = key)?.value?.toBooleanStrictOrNull() ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Byte] number and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this [EnvironmentVariableStore]
 * with the provided [key].
 * @throws NumberFormatException if the string is not a valid representation of a number.
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @return The [Byte] value corresponding to the environment variable in this [EnvironmentVariableStore] identified by
 * the provided [key].
 *
 * @see [String.toByte]
 */
fun EnvironmentVariableStore.getByte(
    key: String,
    radix: Int = 10
): Byte = get(key = key).value.toByte(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Byte] number and returns the result or `null` if the [String]
 * value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toByteOrNull]
 */
fun EnvironmentVariableStore.getByteOrNull(
    key: String,
    radix: Int = 10
): Byte? = getOrNull(key = key)?.value?.toByteOrNull(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Byte] number and returns the result or the provided [defaultValue]
 * if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toByteOrNull]
 */
fun EnvironmentVariableStore.getByteOrDefault(
    key: String,
    defaultValue: Byte,
    radix: Int = 10
): Byte = getOrNull(key = key)?.value?.toByteOrNull(radix) ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Short] number and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this [EnvironmentVariableStore]
 * with the provided [key].
 * @throws NumberFormatException if the string is not a valid representation of a number.
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @return The [Short] value corresponding to the environment variable in this [EnvironmentVariableStore] identified by
 * the provided [key].
 *
 * @see [String.toShort]
 */
fun EnvironmentVariableStore.getShort(
    key: String,
    radix: Int = 10
): Short = get(key = key).value.toShort(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Short] number and returns the result or `null` if the [String]
 * value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toShortOrNull]
 */
fun EnvironmentVariableStore.getShortOrNull(
    key: String,
    radix: Int = 10
): Short? = getOrNull(key = key)?.value?.toShortOrNull(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Short] number and returns the result or the provided
 * [defaultValue] if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toShortOrNull]
 */
fun EnvironmentVariableStore.getShortOrDefault(
    key: String,
    defaultValue: Short,
    radix: Int = 10
): Short = getOrNull(key = key)?.value?.toShortOrNull(radix) ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Int] number and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this [EnvironmentVariableStore]
 * with the provided [key].
 * @throws NumberFormatException if the string is not a valid representation of a number.
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @return The [Int] value corresponding to the environment variable in this [EnvironmentVariableStore] identified by
 * the provided [key].
 *
 * @see [String.toInt]
 */
fun EnvironmentVariableStore.getInt(
    key: String,
    radix: Int = 10
): Int = get(key = key).value.toInt(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Int] number and returns the result or `null` if the [String] value
 * is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toIntOrNull]
 */
fun EnvironmentVariableStore.getIntOrNull(
    key: String,
    radix: Int = 10
): Int? = getOrNull(key = key)?.value?.toIntOrNull(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Int] number and returns the result or the provided [defaultValue]
 * if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toIntOrNull]
 */
fun EnvironmentVariableStore.getIntOrDefault(
    key: String,
    defaultValue: Int,
    radix: Int = 10
): Int = getOrNull(key = key)?.value?.toIntOrNull(radix) ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as a [Long] number and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this [EnvironmentVariableStore]
 * with the provided [key].
 * @throws NumberFormatException if the string is not a valid representation of a number.
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @return The [Long] value corresponding to the environment variable in this [EnvironmentVariableStore] identified by
 * the provided [key].
 *
 * @see [String.toLong]
 */
fun EnvironmentVariableStore.getLong(
    key: String,
    radix: Int = 10
): Long = get(key = key).value.toLong(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Long] number and returns the result or `null` if the [String]
 * value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toLongOrNull]
 */
fun EnvironmentVariableStore.getLongOrNull(
    key: String,
    radix: Int = 10
): Long? = getOrNull(key = key)?.value?.toLongOrNull(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Long] number and returns the result or the provided [defaultValue]
 * if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toLongOrNull]
 */
fun EnvironmentVariableStore.getLongOrDefault(
    key: String,
    defaultValue: Long,
    radix: Int = 10
): Long = getOrNull(key = key)?.value?.toLongOrNull(radix) ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Float] number and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this [EnvironmentVariableStore]
 * with the provided [key].
 * @throws NumberFormatException if the string is not a valid representation of a number.
 *
 * @return The [Float] value corresponding to the environment variable in this [EnvironmentVariableStore] identified by
 * the provided [key].
 *
 * @see [String.toFloat]
 */
fun EnvironmentVariableStore.getFloat(
    key: String
): Float = get(key = key).value.toFloat()

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Float] number and returns the result or `null` if the [String]
 * value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @see [String.toFloatOrNull]
 */
fun EnvironmentVariableStore.getFloatOrNull(
    key: String
): Float? = getOrNull(key = key)?.value?.toFloatOrNull()

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Float] number and returns the result or the provided
 * [defaultValue] if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @see [String.toFloatOrNull]
 */
fun EnvironmentVariableStore.getFloatOrDefault(
    key: String,
    defaultValue: Float
): Float = getOrNull(key = key)?.value?.toFloatOrNull() ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Double] number and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this [EnvironmentVariableStore]
 * with the provided [key].
 * @throws NumberFormatException if the string is not a valid representation of a number.
 *
 * @return The [Double] value corresponding to the environment variable in this [EnvironmentVariableStore] identified
 * by the provided [key].
 *
 * @see [String.toInt]
 */
fun EnvironmentVariableStore.getDouble(
    key: String
): Double = get(key = key).value.toDouble()

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Double] number and returns the result or `null` if the [String]
 * value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @see [String.toDoubleOrNull]
 */
fun EnvironmentVariableStore.getDoubleOrNull(
    key: String
): Double? = getOrNull(key = key)?.value?.toDoubleOrNull()

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [Double] number and returns the result or the provided
 * [defaultValue] if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @see [String.toDoubleOrNull]
 */
fun EnvironmentVariableStore.getDoubleOrDefault(
    key: String,
    defaultValue: Double
): Double = getOrNull(key = key)?.value?.toDoubleOrNull() ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [UByte] number and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this [EnvironmentVariableStore]
 * with the provided [key].
 * @throws NumberFormatException if the string is not a valid representation of a number.
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @return The [Byte] value corresponding to the environment variable in this [EnvironmentVariableStore] identified by
 * the provided [key].
 *
 * @see [String.toUByte]
 */
fun EnvironmentVariableStore.getUByte(
    key: String,
    radix: Int = 10
): UByte = get(key = key).value.toUByte(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [UByte] number and returns the result or `null` if the [String]
 * value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toUByteOrNull]
 */
fun EnvironmentVariableStore.getUByteOrNull(
    key: String,
    radix: Int = 10
): UByte? = getOrNull(key = key)?.value?.toUByteOrNull(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [UByte] number and returns the result or the provided
 * [defaultValue] if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toUByteOrNull]
 */
fun EnvironmentVariableStore.getUByteOrDefault(
    key: String,
    defaultValue: UByte,
    radix: Int = 10
): UByte = getOrNull(key = key)?.value?.toUByteOrNull(radix) ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [UShort] number and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this [EnvironmentVariableStore]
 * with the provided [key].
 * @throws NumberFormatException if the string is not a valid representation of a number.
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @return The [Short] value corresponding to the environment variable in this [EnvironmentVariableStore] identified by
 * the provided [key].
 *
 * @see [String.toUShort]
 */
fun EnvironmentVariableStore.getUShort(
    key: String,
    radix: Int = 10
): UShort = get(key = key).value.toUShort(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [UShort] number and returns the result or `null` if the [String]
 * value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toUShortOrNull]
 */
fun EnvironmentVariableStore.getUShortOrNull(
    key: String,
    radix: Int = 10
): UShort? = getOrNull(key = key)?.value?.toUShortOrNull(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [UShort] number and returns the result or the provided
 * [defaultValue] if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toUShortOrNull]
 */
fun EnvironmentVariableStore.getUShortOrDefault(
    key: String,
    defaultValue: UShort,
    radix: Int = 10
): UShort = getOrNull(key = key)?.value?.toUShortOrNull(radix) ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [UInt] number and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this [EnvironmentVariableStore]
 * with the provided [key].
 * @throws NumberFormatException if the string is not a valid representation of a number.
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @return The [Int] value corresponding to the environment variable in this [EnvironmentVariableStore] identified by
 * the provided [key].
 *
 * @see [String.toUInt]
 */
fun EnvironmentVariableStore.getUInt(
    key: String,
    radix: Int = 10
): UInt = get(key = key).value.toUInt(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [UInt] number and returns the result or `null` if the [String]
 * value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toUIntOrNull]
 */
fun EnvironmentVariableStore.getUIntOrNull(
    key: String,
    radix: Int = 10
): UInt? = getOrNull(key = key)?.value?.toUIntOrNull(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [UInt] number and returns the result or the provided [defaultValue]
 * if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toUIntOrNull]
 */
fun EnvironmentVariableStore.getUIntOrDefault(
    key: String,
    defaultValue: UInt,
    radix: Int = 10
): UInt = getOrNull(key = key)?.value?.toUIntOrNull(radix) ?: defaultValue

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as a [ULong] number and returns the result.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @throws [NoSuchEnvironmentVariableException] if there is no environment variable in this [EnvironmentVariableStore]
 * with the provided [key].
 * @throws NumberFormatException if the string is not a valid representation of a number.
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @return The [Long] value corresponding to the environment variable in this [EnvironmentVariableStore] identified by
 * the provided [key].
 *
 * @see [String.toULong]
 */
fun EnvironmentVariableStore.getULong(
    key: String,
    radix: Int = 10
): ULong = get(key = key).value.toULong(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [ULong] number and returns the result or `null` if the [String]
 * value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toULongOrNull]
 */
fun EnvironmentVariableStore.getULongOrNull(
    key: String,
    radix: Int = 10
): ULong? = getOrNull(key = key)?.value?.toULongOrNull(radix)

/**
 * Retrieves the [EnvironmentVariable.Value] corresponding to the provided [key] and then parses the
 * [EnvironmentVariable.Value.value] [String] as an [ULong] number and returns the result or the provided
 * [defaultValue] if the [String] value is not a valid representation of a number.
 *
 * @param [key] The name of the environment variable whose value is being retrieved.
 *
 * @param [radix] The radix number used in the string to number conversion process. Defaults to `10`.
 *
 * @throws IllegalArgumentException when [radix] is not a valid radix for string to number conversion.
 *
 * @see [String.toULongOrNull]
 */
fun EnvironmentVariableStore.getULongOrDefault(
    key: String,
    defaultValue: ULong,
    radix: Int = 10
): ULong = getOrNull(key = key)?.value?.toULongOrNull(radix) ?: defaultValue
