//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getVariableOrDefault](get-variable-or-default.md)

# getVariableOrDefault

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getVariableOrDefault](get-variable-or-default.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), defaultValue: [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md)): [EnvironmentVariable](../com.mooncloak.kodetools.kenv/-environment-variable/index.md)

Retrieves an environment variable from this [EnvironmentVariableStore](-environment-variable-store/index.md) instance for the provided [key](get-variable-or-default.md), or [defaultValue](get-variable-or-default.md) if no environment variable exists for that key.

#### Return

The [EnvironmentVariable](../com.mooncloak.kodetools.kenv/-environment-variable/index.md) corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) instance with the provided [key](get-variable-or-default.md), or the provided [defaultValue](get-variable-or-default.md) if there is no value for the provided [key](get-variable-or-default.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |
