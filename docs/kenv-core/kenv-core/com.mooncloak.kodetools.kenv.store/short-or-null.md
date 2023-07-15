//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[shortOrNull](short-or-null.md)

# shortOrNull

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[shortOrNull](short-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)?&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](short-or-null.md) (or the name of the delegated variable if the [key](short-or-null.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](short-or-null.md) then `null` is returned.
