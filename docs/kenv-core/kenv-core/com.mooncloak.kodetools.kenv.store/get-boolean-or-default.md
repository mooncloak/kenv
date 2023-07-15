//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getBooleanOrDefault](get-boolean-or-default.md)

# getBooleanOrDefault

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getBooleanOrDefault](get-boolean-or-default.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), defaultValue: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-boolean-or-default.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as an [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) and returns the result or the provided [defaultValue](get-boolean-or-default.md) if the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value is not a valid representation of a number.

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### See also

| |
|---|
| [toBooleanStrictOrNull](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) |
