//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv](index.md)/[xmlProperties](xml-properties.md)

# xmlProperties

[jvm]\
fun [KenvBuilder](-kenv-builder/index.md).[xmlProperties](xml-properties.md)(inputStream: [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html))

Creates an [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided [inputStream](xml-properties.md) containing XML [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) and adds it to the [Kenv](-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

jvm

| | |
|---|---|
| inputStream | The [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html) containing XML [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) to add. |

#### See also

| | |
|---|---|
| [Properties.loadFromXML](https://developer.android.com/reference/kotlin/java/util/Properties.html#loadfromxml) | For the internal function this calls to load the properties from the provided [inputStream](xml-properties.md). |

[jvm]\
fun [KenvBuilder](-kenv-builder/index.md).[xmlProperties](xml-properties.md)(file: [File](https://developer.android.com/reference/kotlin/java/io/File.html))

Creates an [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided XML [file](xml-properties.md) containing [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) and adds it to the [Kenv](-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

jvm

| | |
|---|---|
| file | The [File](https://developer.android.com/reference/kotlin/java/io/File.html) containing XML [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) to add. |

#### See also

| | |
|---|---|
| [Properties.loadFromXML](https://developer.android.com/reference/kotlin/java/util/Properties.html#loadfromxml) | For the internal function this calls to load the properties from the provided XML [file](xml-properties.md). |

[jvm]\
fun [KenvBuilder](-kenv-builder/index.md).[xmlProperties](xml-properties.md)(path: Path)

Creates an [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) from the provided XML file [path](xml-properties.md) containing [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) and adds it to the [Kenv](-kenv/index.md) instance being created in the order this function is invoked.

#### Parameters

jvm

| | |
|---|---|
| path | The file Path containing XML [Properties](https://developer.android.com/reference/kotlin/java/util/Properties.html) to add. |

#### See also

| | |
|---|---|
| [Properties.loadFromXML](https://developer.android.com/reference/kotlin/java/util/Properties.html#loadfromxml) | For the internal function this calls to load the properties from the provided XML file [path](xml-properties.md). |
