//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[ubyte](ubyte.md)

# ubyte

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[ubyte](ubyte.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, defaultValue: [UByte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html)): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, [UByte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [UByte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](ubyte.md) (or the name of the delegated variable if the [key](ubyte.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](ubyte.md) then the `defaultValue` is used.
