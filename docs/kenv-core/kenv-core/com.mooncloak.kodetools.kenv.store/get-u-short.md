//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getUShort](get-u-short.md)

# getUShort

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getUShort](get-u-short.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), radix: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 10): [UShort](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-u-short.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as an [UShort](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html) number and returns the result.

#### Return

The [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) value corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) identified by the provided [key](get-u-short.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### See also

| |
|---|
| [toUShort](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) |

#### Throws

| | |
|---|---|
| [NoSuchEnvironmentVariableException](../com.mooncloak.kodetools.kenv.exception/-no-such-environment-variable-exception/index.md) | if there is no environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) with the provided [key](get-u-short.md). |
| [NumberFormatException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number-format-exception/index.html) | if the string is not a valid representation of a number. |
| [IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | when [radix](get-u-short.md) is not a valid radix for string to number conversion. |
