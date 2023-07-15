//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv](index.md)/[[jvm]dotenv]([jvm]dotenv.md)

# dotenv

[jvm]\
fun [KenvBuilder](-kenv-builder/index.md#-151892319%2FMain%2F1271432740).[dotenv]([jvm]dotenv.md)(file: [File](https://developer.android.com/reference/kotlin/java/io/File.html), normalize: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, fileSystem: FileSystem = FileSystem.platformDefault, options: [DotEnvParser.Options](../../../kenv-core/kenv-core/com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) = DotEnvParser.Options())

Creates an [EnvironmentVariableStore](../../../kenv-core/kenv-core/com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided &quot;.env&quot; file [File](https://developer.android.com/reference/kotlin/java/io/File.html) and [fileSystem]([jvm]dotenv.md) and adds it to the [Kenv](../../../kenv-core/kenv-core/com.mooncloak.kodetools.kenv/-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

jvm

| | |
|---|---|
| file | The &quot;.env&quot; [File](https://developer.android.com/reference/kotlin/java/io/File.html). |
| normalize | Whether the [File](https://developer.android.com/reference/kotlin/java/io/File.html) should be normalized. See Path.Companion.toPath. |
| fileSystem | The FileSystem where the &quot;.env&quot; file resides. |
| options | The [DotEnvParser.Options](../../../kenv-core/kenv-core/com.mooncloak.kodetools.kenv.parse/-dot-env-parser/-options/index.md) used during the parsing of the &quot;.env&quot; file. |
