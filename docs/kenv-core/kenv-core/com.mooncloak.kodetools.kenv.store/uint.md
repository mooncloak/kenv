//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[uint](uint.md)

# uint

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[uint](uint.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, defaultValue: [UInt](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-int/index.html)): [ReadOnlyProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [UInt](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-int/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [UInt](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-u-int/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](uint.md) (or the name of the delegated variable if the [key](uint.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](uint.md) then the `defaultValue` is used.
