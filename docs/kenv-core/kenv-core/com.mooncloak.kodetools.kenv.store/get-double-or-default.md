//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getDoubleOrDefault](get-double-or-default.md)

# getDoubleOrDefault

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getDoubleOrDefault](get-double-or-default.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), defaultValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-double-or-default.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as an [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) number and returns the result or the provided [defaultValue](get-double-or-default.md) if the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value is not a valid representation of a number.

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### See also

| |
|---|
| [toDoubleOrNull](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) |
