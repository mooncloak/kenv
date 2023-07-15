//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getUByte](get-u-byte.md)

# getUByte

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getUByte](get-u-byte.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), radix: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 10): [UByte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html)

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-u-byte.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as an [UByte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html) number and returns the result.

#### Return

The [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) value corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) identified by the provided [key](get-u-byte.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### See also

| |
|---|
| [toUByte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) |

#### Throws

| | |
|---|---|
| [NoSuchEnvironmentVariableException](../com.mooncloak.kodetools.kenv.exception/-no-such-environment-variable-exception/index.md) | if there is no environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) with the provided [key](get-u-byte.md). |
| [NumberFormatException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number-format-exception/index.html) | if the string is not a valid representation of a number. |
| [IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | when [radix](get-u-byte.md) is not a valid radix for string to number conversion. |
