//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getBoolean](get-boolean.md)

# getBoolean

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getBoolean](get-boolean.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-boolean.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) as an [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) and returns the result.

#### Return

The [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) value corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) identified by the provided [key](get-boolean.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### See also

| |
|---|
| [toBoolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/index.html) |
