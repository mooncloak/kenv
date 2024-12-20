//[kenv-core](../../../../index.md)/[com.mooncloak.kodetools.kenv.parse](../../index.md)/[DotEnvParser](../index.md)/[Options](index.md)

# Options

[common]\
class [Options](index.md)(val includeEmptyValues: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false)

Parsing options for a [DotEnvParser](../index.md) instance.

## Constructors

| | |
|---|---|
| [Options](-options.md) | [common]<br>constructor(includeEmptyValues: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false) |

## Properties

| Name | Summary |
|---|---|
| [includeEmptyValues](include-empty-values.md) | [common]<br>val [includeEmptyValues](include-empty-values.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false<br>If this is `false` and an environment variable is encountered that does not have an associated value assigned to it, a [DotEnvParseException](../../../com.mooncloak.kodetools.kenv.exception/-dot-env-parse-exception/index.md) will be thrown, otherwise, an environment variable will be created with an empty [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) as its value. Defaults to `false`. |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
