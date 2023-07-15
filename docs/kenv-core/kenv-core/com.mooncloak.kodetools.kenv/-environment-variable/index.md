//[kenv-core](../../../index.md)/[com.mooncloak.kodetools.kenv](../index.md)/[EnvironmentVariable](index.md)

# EnvironmentVariable

[common]\
class [EnvironmentVariable](index.md)(val key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val value: [EnvironmentVariable.Value](-value/index.md))

## Constructors

| | |
|---|---|
| [EnvironmentVariable](-environment-variable.md) | [common]<br>constructor(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [EnvironmentVariable.Value](-value/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Value](-value/index.md) | [common]<br>@[JvmInline](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-inline/index.html)<br>value class [Value](-value/index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Represents the value of an [EnvironmentVariable](index.md). |

## Functions

| Name | Summary |
|---|---|
| [component1](component1.md) | [common]<br>operator fun [component1](component1.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [component2](component2.md) | [common]<br>operator fun [component2](component2.md)(): [EnvironmentVariable.Value](-value/index.md) |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [key](key.md) | [common]<br>val [key](key.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [value](value.md) | [common]<br>val [value](value.md): [EnvironmentVariable.Value](-value/index.md) |
