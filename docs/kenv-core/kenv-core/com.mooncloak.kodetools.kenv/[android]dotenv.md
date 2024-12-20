//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv](index.md)/[[android]dotenv]([android]dotenv.md)

# dotenv

[android]\
fun [KenvBuilder](-kenv-builder/index.md).[dotenv]([android]dotenv.md)(file: [File](https://developer.android.com/reference/kotlin/java/io/File.html), normalize: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, fileSystem: FileSystem = FileSystem.platformDefault, options: [DotEnvParser.Options](../com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) = DotEnvParser.Options())

Creates an [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided &quot;.env&quot; file [File](https://developer.android.com/reference/kotlin/java/io/File.html) and [fileSystem]([android]dotenv.md) and adds it to the [Kenv](-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

android

| | |
|---|---|
| file | The &quot;.env&quot; [File](https://developer.android.com/reference/kotlin/java/io/File.html). |
| normalize | Whether the [File](https://developer.android.com/reference/kotlin/java/io/File.html) should be normalized. See Path.Companion.toPath. |
| fileSystem | The FileSystem where the &quot;.env&quot; file resides. |
| options | The [DotEnvParser.Options](../com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) used during the parsing of the &quot;.env&quot; file. |
