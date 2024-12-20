//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getULong](get-u-long.md)

# getULong

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getULong](get-u-long.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), radix: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 10): [ULong](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-long/index.html)

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-u-long.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) as a [ULong](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-long/index.html) number and returns the result.

#### Return

The [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) value corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) identified by the provided [key](get-u-long.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### See also

| |
|---|
| [toULong](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/index.html) |

#### Throws

| | |
|---|---|
| [NoSuchEnvironmentVariableException](../com.mooncloak.kodetools.kenv.exception/-no-such-environment-variable-exception/index.md) | if there is no environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) with the provided [key](get-u-long.md). |
| [NumberFormatException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-number-format-exception/index.html) | if the string is not a valid representation of a number. |
| [IllegalArgumentException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-illegal-argument-exception/index.html) | when [radix](get-u-long.md) is not a valid radix for string to number conversion. |
