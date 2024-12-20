//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[short](short.md)

# short

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[short](short.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, defaultValue: [Short](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-short/index.html) = 0): [ReadOnlyProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [Short](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-short/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [Short](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-short/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](short.md) (or the name of the delegated variable if the [key](short.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](short.md) then the `defaultValue` is used.
