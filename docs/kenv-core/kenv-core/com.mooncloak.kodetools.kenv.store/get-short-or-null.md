//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getShortOrNull](get-short-or-null.md)

# getShortOrNull

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getShortOrNull](get-short-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), radix: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 10): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)?

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-short-or-null.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as an [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) number and returns the result or `null` if the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value is not a valid representation of a number.

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |
| radix | The radix number used in the string to number conversion process. Defaults to `10`. |

#### See also

| |
|---|
| [toShortOrNull](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) |

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | when [radix](get-short-or-null.md) is not a valid radix for string to number conversion. |
