//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[long](long.md)

# long

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[long](long.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, defaultValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](long.md) (or the name of the delegated variable if the [key](long.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](long.md) then the `defaultValue` is used.
