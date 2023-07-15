//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[intOrNull](int-or-null.md)

# intOrNull

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[intOrNull](int-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](int-or-null.md) (or the name of the delegated variable if the [key](int-or-null.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](int-or-null.md) then `null` is returned.
