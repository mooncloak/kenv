//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[ulong](ulong.md)

# ulong

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[ulong](ulong.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, defaultValue: [ULong](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-long/index.html)): [ReadOnlyProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [ULong](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-long/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [ULong](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-long/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](ulong.md) (or the name of the delegated variable if the [key](ulong.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](ulong.md) then the `defaultValue` is used.
