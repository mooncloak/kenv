//[kenv-core](../../../index.md)/[com.mooncloak.kodetools.kenv](../index.md)/[System](index.md)/[get](get.md)

# get

[common]\
open operator override fun [get](get.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [EnvironmentVariable.Value](../-environment-variable/-value/index.md)

Retrieves an environment variable value from this [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) instance for the provided [key](get.md), or throws a [NoSuchEnvironmentVariableException](../../com.mooncloak.kodetools.kenv.exception/-no-such-environment-variable-exception/index.md) if no environment variable exists for that key.

#### Return

The [EnvironmentVariable.Value](../-environment-variable/-value/index.md) corresponding to the environment variable in this [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) instance with the provided [key](get.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### Throws

| | |
|---|---|
| [NoSuchEnvironmentVariableException](../../com.mooncloak.kodetools.kenv.exception/-no-such-environment-variable-exception/index.md) | if there is no environment variable in this [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) instance with the provided [key](get.md). |
