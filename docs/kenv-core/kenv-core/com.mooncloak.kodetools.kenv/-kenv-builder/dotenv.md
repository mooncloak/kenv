//[kenv-core](../../../index.md)/[com.mooncloak.kodetools.kenv](../index.md)/[KenvBuilder](index.md)/[dotenv](dotenv.md)

# dotenv

[common]\
fun [dotenv](dotenv.md)(source: Source, options: [DotEnvParser.Options](../../com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) = DotEnvParser.Options())

Creates an [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided [source](dotenv.md) and adds it to the [Kenv](../-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

common

| | |
|---|---|
| source | The Source of a &quot;.env&quot; file. |
| options | The [DotEnvParser.Options](../../com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) used during the parsing of the &quot;.env&quot; file. |

[common]\
fun [dotenv](dotenv.md)(path: Path, fileSystem: FileSystem = FileSystem.platformDefault, options: [DotEnvParser.Options](../../com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) = DotEnvParser.Options())

Creates an [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided &quot;.env&quot; file [path](dotenv.md) and [fileSystem](dotenv.md) and adds it to the [Kenv](../-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

common

| | |
|---|---|
| path | The Path to the &quot;.env&quot; file. |
| fileSystem | The FileSystem where the &quot;.env&quot; file resides. |
| options | The [DotEnvParser.Options](../../com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) used during the parsing of the &quot;.env&quot; file. |

[common]\
fun [dotenv](dotenv.md)(pathString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), normalize: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, fileSystem: FileSystem = FileSystem.platformDefault, options: [DotEnvParser.Options](../../com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) = DotEnvParser.Options())

Creates an [EnvironmentVariableStore](../../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided &quot;.env&quot; file [pathString](dotenv.md) and [fileSystem](dotenv.md) and adds it to the [Kenv](../-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

common

| | |
|---|---|
| pathString | The [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) path to the &quot;.env&quot; file. |
| normalize | Whether the [pathString](dotenv.md) should be normalized. See Path.Companion.toPath. |
| fileSystem | The FileSystem where the &quot;.env&quot; file resides. |
| options | The [DotEnvParser.Options](../../com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) used during the parsing of the &quot;.env&quot; file. |
