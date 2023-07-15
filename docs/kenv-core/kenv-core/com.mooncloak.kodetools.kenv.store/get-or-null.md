//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getOrNull](get-or-null.md)

# getOrNull

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getOrNull](get-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md)?

Retrieves an environment variable value from this [EnvironmentVariableStore](-environment-variable-store/index.md) instance for the provided [key](get-or-null.md), or `null` if no environment variable exists for that key.

#### Return

The [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) instance with the provided [key](get-or-null.md), or `null` if there is no value for the provided [key](get-or-null.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |
