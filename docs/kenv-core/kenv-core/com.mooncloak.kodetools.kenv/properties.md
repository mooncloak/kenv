//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv](index.md)/[properties](properties.md)

# properties

[jvm]\
fun [KenvBuilder](-kenv-builder/index.md).[properties](properties.md)(properties: [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html))

Creates an [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided [properties](properties.md) and adds it to the [Kenv](-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

jvm

| | |
|---|---|
| properties | The properties to add. |

[jvm]\
fun [KenvBuilder](-kenv-builder/index.md).[properties](properties.md)(inputStream: [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html))

Creates an [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided [inputStream](properties.md) containing [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) and adds it to the [Kenv](-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

jvm

| | |
|---|---|
| inputStream | The [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html) containing [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) to add. |

#### See also

| | |
|---|---|
| [Properties.load](https://developer.android.com/reference/kotlin/java/util/Properties.html#load) | For the internal function this calls to load the properties from the provided [inputStream](properties.md). |

[jvm]\
fun [KenvBuilder](-kenv-builder/index.md).[properties](properties.md)(file: [File](https://developer.android.com/reference/kotlin/java/io/File.html))

Creates an [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided [file](properties.md) containing [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) and adds it to the [Kenv](-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

jvm

| | |
|---|---|
| file | The [File](https://developer.android.com/reference/kotlin/java/io/File.html) containing [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) to add. |

#### See also

| | |
|---|---|
| [Properties.load](https://developer.android.com/reference/kotlin/java/util/Properties.html#load) | For the internal function this calls to load the properties from the provided [file](properties.md). |

[jvm]\
fun [KenvBuilder](-kenv-builder/index.md).[properties](properties.md)(path: Path)

Creates an [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided file [path](properties.md) containing [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) and adds it to the [Kenv](-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

jvm

| | |
|---|---|
| path | The file Path containing [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) to add. |

#### See also

| | |
|---|---|
| [Properties.load](https://developer.android.com/reference/kotlin/java/util/Properties.html#load) | For the internal function this calls to load the properties from the provided file [path](properties.md). |
