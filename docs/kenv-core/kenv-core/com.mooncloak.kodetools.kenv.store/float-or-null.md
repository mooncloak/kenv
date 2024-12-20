//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[floatOrNull](float-or-null.md)

# floatOrNull

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[floatOrNull](float-or-null.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null): [ReadOnlyProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)?&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](float-or-null.md) (or the name of the delegated variable if the [key](float-or-null.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](float-or-null.md) then `null` is returned.
