//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[double](double.md)

# double

[common]\
fun [EnvironmentVariableStore](-environment-variable-store/index.md).[double](double.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, defaultValue: [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html) = 0.0): [ReadOnlyProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-only-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)&gt;

Retrieves a property delegate representing an [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md), converted to an [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), retrieved from this [EnvironmentVariableStore](-environment-variable-store/index.md) using the provided [key](double.md) (or the name of the delegated variable if the [key](double.md) is `null`), or if there is no matching [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) for the [key](double.md) then the `defaultValue` is used.
