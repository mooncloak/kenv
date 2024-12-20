//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getBooleanOrNull](get-boolean-or-null.md)

# getBooleanOrNull

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getBooleanOrNull](get-boolean-or-null.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)?

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-boolean-or-null.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) as an [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) and returns the result or `null` if the [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) value is not a valid representation of a number.

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### See also

| |
|---|
| [toBooleanStrictOrNull](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/index.html) |
