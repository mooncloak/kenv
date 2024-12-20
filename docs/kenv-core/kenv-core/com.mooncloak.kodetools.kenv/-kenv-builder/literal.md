//[kenv-core](../../../index.md)/[com.mooncloak.kodetools.kenv](../index.md)/[KenvBuilder](index.md)/[literal](literal.md)

# literal

[common]\
fun [literal](literal.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), options: [DotEnvParser.Options](../../com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) = DotEnvParser.Options())

Creates an [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided literal [String](literal.md) representing the contents of a &quot;.env&quot; file and adds it to the [Kenv](../-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

common

| | |
|---|---|
| value | The [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) contents of a &quot;.env&quot; file. |
| options | The [DotEnvParser.Options](../../com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) used during the parsing of the &quot;.env&quot; file. |
