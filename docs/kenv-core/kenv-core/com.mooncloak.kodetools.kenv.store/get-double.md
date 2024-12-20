//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getDouble](get-double.md)

# getDouble

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getDouble](get-double.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-double.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) as an [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html) number and returns the result.

#### Return

The [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html) value corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) identified by the provided [key](get-double.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### See also

| |
|---|
| [toInt](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/index.html) |

#### Throws

| | |
|---|---|
| [NoSuchEnvironmentVariableException](../com.mooncloak.kodetools.kenv.exception/-no-such-environment-variable-exception/index.md) | if there is no environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) with the provided [key](get-double.md). |
| [NumberFormatException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-number-format-exception/index.html) | if the string is not a valid representation of a number. |
