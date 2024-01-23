//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getStringOrDefault](get-string-or-default.md)

# getStringOrDefault

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getStringOrDefault](get-string-or-default.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), defaultValue: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-string-or-default.md) and returns the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) or the provided [defaultValue](get-string-or-default.md) if the key does not exist.

#### Return

The [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) identified by the provided [key](get-string-or-default.md), or the [defaultValue](get-string-or-default.md) if it isn't present.

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |
