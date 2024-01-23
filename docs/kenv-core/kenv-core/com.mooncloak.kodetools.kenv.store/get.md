//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[get](get.md)

# get

[common]\
inline fun &lt;[R](get.md)&gt; [EnvironmentVariableStore](-environment-variable-store/index.md).[get](get.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), mapper: ([EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md)) -&gt; [R](get.md)): [R](get.md)

Retrieves a value resulting from invoking the provided [mapper](get.md) function with the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) obtained using [get](get.md) for the provided [key](get.md).

#### Return

The result of invoking the provided [mapper](get.md) function with the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) obtained for the provided [key](get.md).

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |

#### Throws

| | |
|---|---|
| [NoSuchEnvironmentVariableException](../com.mooncloak.kodetools.kenv.exception/-no-such-environment-variable-exception/index.md) | if there is no environment variable in this [EnvironmentVariableStore](-environment-variable-store/index.md) with the provided [key](get.md). |
