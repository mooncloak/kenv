//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv.store](index.md)/[getShortOrDefault](get-short-or-default.md)

# getShortOrDefault

[common]\
inline fun [EnvironmentVariableStore](-environment-variable-store/index.md).[getShortOrDefault](get-short-or-default.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), defaultValue: [Short](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-short/index.html), radix: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 10): [Short](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-short/index.html)

Retrieves the [EnvironmentVariable.Value](../com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md) corresponding to the provided [key](get-short-or-default.md) and then parses the [EnvironmentVariable.Value.value](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) as an [Short](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-short/index.html) number and returns the result or the provided [defaultValue](get-short-or-default.md) if the [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) value is not a valid representation of a number.

#### Parameters

common

| | |
|---|---|
| key | The name of the environment variable whose value is being retrieved. |
| radix | The radix number used in the string to number conversion process. Defaults to `10`. |

#### See also

| |
|---|
| [toShortOrNull](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/index.html) |

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-illegal-argument-exception/index.html) | when [radix](get-short-or-default.md) is not a valid radix for string to number conversion. |
