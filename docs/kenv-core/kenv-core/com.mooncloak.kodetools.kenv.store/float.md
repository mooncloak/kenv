//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[float](float.md)

# float

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[float](float.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, defaultValue: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) = 0.0f): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](float.md) (or the name of the delegated variable if the [key](float.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](float.md) then the `defaultValue` is used.
