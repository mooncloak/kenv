//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[boolean](boolean.md)

# boolean

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[boolean](boolean.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, defaultValue: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [ReadOnlyProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](boolean.md) (or the name of the delegated variable if the [key](boolean.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](boolean.md) then the `defaultValue` is used.

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[boolean](boolean.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, defaultValue: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [ReadOnlyProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](boolean.md) (or the name of the delegated variable if the [key](boolean.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](boolean.md) then the `defaultValue` is used.
