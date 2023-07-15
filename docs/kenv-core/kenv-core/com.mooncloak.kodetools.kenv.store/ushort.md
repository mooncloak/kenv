//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[ushort](ushort.md)

# ushort

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[ushort](ushort.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, defaultValue: [UShort](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, [UShort](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [UShort](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-short/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](ushort.md) (or the name of the delegated variable if the [key](ushort.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](ushort.md) then the `defaultValue` is used.
