//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getStringOrNull](get-string-or-null.md)

# getStringOrNull

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getStringOrNull](get-string-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-string-or-null.md) and returns the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).

#### Return

The [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) identified by the provided [key](get-string-or-null.md), or `null` if it isn't present.

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |
