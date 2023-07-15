//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[byte](byte.md)

# byte

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[byte](byte.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, defaultValue: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](byte.md) (or the name of the delegated variable if the [key](byte.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](byte.md) then the `defaultValue` is used.
