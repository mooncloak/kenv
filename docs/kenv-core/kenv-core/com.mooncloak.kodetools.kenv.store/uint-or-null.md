//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[uintOrNull](uint-or-null.md)

# uintOrNull

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[uintOrNull](uint-or-null.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null): [ReadOnlyProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [UInt](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-int/index.html)?&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [UInt](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-int/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](uint-or-null.md) (or the name of the delegated variable if the [key](uint-or-null.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](uint-or-null.md) then `null` is returned.
