//[kenv-core](../../../index.md)/[com.mooncloak.kodetools.kenv.store](../index.md)/[EnvironmentVariableStore](index.md)/[getVariable](get-variable.md)

# getVariable

[common]\
open fun [getVariable](get-variable.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [EnvironmentVariable](../../com.mooncloak.kodetools.kenv/-environment-variable/index.md)

Retrieves an environment variable from this [EnvironmentVariableStore](index.md) instance for the provided [key](get-variable.md), or throws a [NoSuchEnvironmentVariableException](../../com.mooncloak.kodetools.kenv.exception/-no-such-environment-variable-exception/index.md) if no environment variable exists for that key.

#### Return

The [EnvironmentVariable](../../com.mooncloak.kodetools.kenv/-environment-variable/index.md) corresponding to the environment variable in this [EnvironmentVariableStore](index.md) instance with the provided [key](get-variable.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### Throws

| | |
|---|---|
| [NoSuchEnvironmentVariableException](../../com.mooncloak.kodetools.kenv.exception/-no-such-environment-variable-exception/index.md) | if there is no environment variable in this [EnvironmentVariableStore](index.md) instance with the provided [key](get-variable.md). |
