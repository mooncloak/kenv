//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getULongOrNull](get-u-long-or-null.md)

# getULongOrNull

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getULongOrNull](get-u-long-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), radix: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 10): [ULong](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)?

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-u-long-or-null.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as an [ULong](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html) number and returns the result or `null` if the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value is not a valid representation of a number.

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |
| radix | The radix number used in the string to number conversion process. Defaults to `10`. |

#### See also

| |
|---|
| [toULongOrNull](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) |

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | when [radix](get-u-long-or-null.md) is not a valid radix for string to number conversion. |
