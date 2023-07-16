//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getString](get-string.md)

# getString

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getString](get-string.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-string.md) and then returns the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).

#### Return

The [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value corresponding to the environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) identified by the provided [key](get-string.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |
