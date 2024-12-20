//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[stringOrNull](string-or-null.md)

# stringOrNull

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[stringOrNull](string-or-null.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null): [ReadOnlyProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](string-or-null.md) (or the name of the delegated variable if the [key](string-or-null.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](string-or-null.md) then `null` is returned.
