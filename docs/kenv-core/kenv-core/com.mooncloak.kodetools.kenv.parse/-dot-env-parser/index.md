//[kenv-core](../../../index.md)/[com.mooncloak.kodetools.kenv.parse](../index.md)/[DotEnvParser](index.md)

# DotEnvParser

[common]\
class [DotEnvParser](index.md)

A component that is responsible for parsing a Dot Env (&quot;.env&quot;) [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) file to obtain a collection of [EnvironmentVariable](../../com.mooncloak.kodetools.kenv/-environment-variable/index.md)s.

## Types

| Name | Summary |
|---|---|
| [Options](-options/index.md) | [common]<br>class [Options](-options/index.md)(val includeEmptyValues: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Parsing options for a [DotEnvParser](index.md) instance. |

## Functions

| Name | Summary |
|---|---|
| [parse](parse.md) | [common]<br>fun [parse](parse.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EnvironmentVariable](../../com.mooncloak.kodetools.kenv/-environment-variable/index.md)&gt;<br>A convenience function for invoking the [parse](parse.md) with a [LineReaderSource](../../../../kenv-core/com.mooncloak.kodetools.kenv.parse/-line-reader-source/index.md) obtained from the provided [String](parse.md).<br>[common]<br>fun [parse](parse.md)(source: Source): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EnvironmentVariable](../../com.mooncloak.kodetools.kenv/-environment-variable/index.md)&gt;<br>A convenience function for invoking the [parse](parse.md) with a [LineReaderSource](../../../../kenv-core/com.mooncloak.kodetools.kenv.parse/-line-reader-source/index.md) obtained from the provided [source](parse.md). |
