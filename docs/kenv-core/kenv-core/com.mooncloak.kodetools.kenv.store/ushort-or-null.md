//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[ushortOrNull](ushort-or-null.md)

# ushortOrNull

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[ushortOrNull](ushort-or-null.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null): [ReadOnlyProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [UShort](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-short/index.html)?&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [UShort](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-short/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](ushort-or-null.md) (or the name of the delegated variable if the [key](ushort-or-null.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](ushort-or-null.md) then `null` is returned.
