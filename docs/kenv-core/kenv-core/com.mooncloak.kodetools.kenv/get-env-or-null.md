//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv](index.md)/[getEnvOrNull](get-env-or-null.md)

# getEnvOrNull

[common]\
fun [System](-system/index.md).[getEnvOrNull](get-env-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EnvironmentVariable.Value](-environment-variable/-value/index.md)?

Retrieves an environment variable value from the current [System](-system/index.md) for the provided [key](get-env-or-null.md), or `null` if no environment variable exists for that key.

#### Return

The [EnvironmentVariable.Value](-environment-variable/-value/index.md) corresponding to the environment variable in the system with the provided [key](get-env-or-null.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |
