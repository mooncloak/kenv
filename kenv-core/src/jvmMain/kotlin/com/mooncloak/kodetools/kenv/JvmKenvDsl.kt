@file:Suppress("unused")

package com.mooncloak.kodetools.kenv

import com.mooncloak.kodetools.kenv.parse.DotEnvParser
import com.mooncloak.kodetools.kenv.store.EnvironmentVariableStore
import com.mooncloak.kodetools.kenv.store.PropertiesStore
import com.mooncloak.kodetools.kenv.util.platformDefault
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toOkioPath
import okio.Path.Companion.toPath
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.Properties

/**
 * Creates an [EnvironmentVariableStore] from the provided ".env" file [File] and [fileSystem] and adds it to the
 * [Kenv] instance being created in the order this function is invoked.
 *
 * @param [file] The ".env" [File].
 * @param [normalize] Whether the [File] should be normalized. See [Path.Companion.toPath].
 * @param [fileSystem] The [FileSystem] where the ".env" file resides.
 * @param [options] The [DotEnvParser.Options] used during the parsing of the ".env" file.
 */
fun KenvBuilder.dotenv(
    file: File,
    normalize: Boolean = false,
    fileSystem: FileSystem = FileSystem.platformDefault,
    options: DotEnvParser.Options = DotEnvParser.Options()
) {
    dotenv(
        path = file.toOkioPath(normalize = normalize),
        fileSystem = fileSystem,
        options = options
    )
}

/**
 * Creates an [EnvironmentVariableStore] from the provided [properties] and adds it to the [Kenv] instance being
 * created in the order this function is invoked.
 *
 * @param [properties] The properties to add.
 */
fun KenvBuilder.properties(
    properties: Properties
) {
    store(store = PropertiesStore(properties = properties))
}

/**
 * Creates an [EnvironmentVariableStore] from the provided [inputStream] containing [Properties] and adds it to the
 * [Kenv] instance being created in the order this function is invoked.
 *
 * @param [inputStream] The [InputStream] containing [Properties] to add.
 *
 * @see [Properties.load] For the internal function this calls to load the properties from the provided [inputStream].
 */
fun KenvBuilder.properties(
    inputStream: InputStream
) {
    val properties = Properties()

    properties.load(inputStream)

    store(store = PropertiesStore(properties = properties))
}

/**
 * Creates an [EnvironmentVariableStore] from the provided [file] containing [Properties] and adds it to the
 * [Kenv] instance being created in the order this function is invoked.
 *
 * @param [file] The [File] containing [Properties] to add.
 *
 * @see [Properties.load] For the internal function this calls to load the properties from the provided [file].
 */
fun KenvBuilder.properties(
    file: File
) {
    val stream = FileInputStream(file)

    val properties = Properties()

    properties.load(stream)

    store(store = PropertiesStore(properties = properties))
}

/**
 * Creates an [EnvironmentVariableStore] from the provided file [path] containing [Properties] and adds it to the
 * [Kenv] instance being created in the order this function is invoked.
 *
 * @param [path] The file [Path] containing [Properties] to add.
 *
 * @see [Properties.load] For the internal function this calls to load the properties from the provided file [path].
 */
fun KenvBuilder.properties(
    path: Path
) {
    val file = path.toFile()
    val stream = FileInputStream(file)

    val properties = Properties()

    properties.load(stream)

    store(store = PropertiesStore(properties = properties))
}

/**
 * Creates an [EnvironmentVariableStore] from the provided [inputStream] containing XML [Properties] and adds it to the
 * [Kenv] instance being created in the order this function is invoked.
 *
 * @param [inputStream] The [InputStream] containing XML [Properties] to add.
 *
 * @see [Properties.loadFromXML] For the internal function this calls to load the properties from the provided
 * [inputStream].
 */
fun KenvBuilder.xmlProperties(
    inputStream: InputStream
) {
    val properties = Properties()

    properties.loadFromXML(inputStream)

    store(store = PropertiesStore(properties = properties))
}

/**
 * Creates an [EnvironmentVariableStore] from the provided XML [file] containing [Properties] and adds it to the
 * [Kenv] instance being created in the order this function is invoked.
 *
 * @param [file] The [File] containing XML [Properties] to add.
 *
 * @see [Properties.loadFromXML] For the internal function this calls to load the properties from the provided XML
 * [file].
 */
fun KenvBuilder.xmlProperties(
    file: File
) {
    val stream = FileInputStream(file)

    val properties = Properties()

    properties.loadFromXML(stream)

    store(store = PropertiesStore(properties = properties))
}

/**
 * Creates an [EnvironmentVariableStore] from the provided XML file [path] containing [Properties] and adds it to the
 * [Kenv] instance being created in the order this function is invoked.
 *
 * @param [path] The file [Path] containing XML [Properties] to add.
 *
 * @see [Properties.loadFromXML] For the internal function this calls to load the properties from the provided XML file
 * [path].
 */
fun KenvBuilder.xmlProperties(
    path: Path
) {
    val file = path.toFile()
    val stream = FileInputStream(file)

    val properties = Properties()

    properties.loadFromXML(stream)

    store(store = PropertiesStore(properties = properties))
}
