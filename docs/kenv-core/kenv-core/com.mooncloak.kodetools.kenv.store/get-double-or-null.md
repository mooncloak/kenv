//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getDoubleOrNull](get-double-or-null.md)

# getDoubleOrNull

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getDoubleOrNull](get-double-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)?

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-double-or-null.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as an [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) number and returns the result or `null` if the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value is not a valid representation of a number.

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### See also

| |
|---|
| [toDoubleOrNull](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) |
