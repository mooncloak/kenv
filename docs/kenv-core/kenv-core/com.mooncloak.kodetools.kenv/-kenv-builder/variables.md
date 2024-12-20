//[kenv-core](../../../index.md)/[com.mooncloak.kodetools.kenv](../index.md)/[KenvBuilder](index.md)/[variables](variables.md)

# variables

[common]\
fun [variables](variables.md)(variables: [Map](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [EnvironmentVariable.Value](../-environment-variable/-value/index.md)&gt;)

Creates an [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) wrapping the provided [variables](variables.md) and adds it to the [Kenv](../-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

common

| | |
|---|---|
| variables | A [Map](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-map/index.html) of [EnvironmentVariable.key](../-environment-variable/key.md) to [EnvironmentVariable](../-environment-variable/index.md)s which are wrapped in an [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) and added to the [Kenv](../-kenv/index.md) instance being created. |

[common]\
fun [variables](variables.md)(variables: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[EnvironmentVariable](../-environment-variable/index.md)&gt;)

Creates an [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) wrapping the provided [variables](variables.md) and adds it to the [Kenv](../-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

common

| | |
|---|---|
| variables | A [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html) of [EnvironmentVariable](../-environment-variable/index.md)s which are wrapped in an [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) and added to the [Kenv](../-kenv/index.md) instance being created. |

[common]\
fun [variables](variables.md)(vararg variables: [EnvironmentVariable](../-environment-variable/index.md))

Creates an [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) wrapping the provided [variables](variables.md) and adds it to the [Kenv](../-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

common

| | |
|---|---|
| variables | A vararg array of [EnvironmentVariable](../-environment-variable/index.md)s which are wrapped in an [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) and added to the [Kenv](../-kenv/index.md) instance being created. |
