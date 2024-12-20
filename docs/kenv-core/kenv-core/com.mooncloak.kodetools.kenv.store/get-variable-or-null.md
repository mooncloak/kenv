//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getVariableOrNull](get-variable-or-null.md)

# getVariableOrNull

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getVariableOrNull](get-variable-or-null.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [EnvironmentVariable](../com.mooncloak.kodetools.kenv/-environment-variable/index.md)?

Retrieves an environment variable from this [EnvironmentVariableStore](-environment-variable-store/index.md) instance for the provided [key](get-variable-or-null.md), or `null` if no environment variable exists for that key.

#### Return

The [EnvironmentVariable](../com.mooncloak.kodetools.kenv/-environment-variable/index.md) corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) instance with the provided [key](get-variable-or-null.md), or `null` if there is no value for the provided [key](get-variable-or-null.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |
