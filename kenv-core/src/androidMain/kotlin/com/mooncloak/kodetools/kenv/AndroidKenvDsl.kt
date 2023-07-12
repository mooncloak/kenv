@file:Suppress("unused")

package com.mooncloak.kodetools.kenv

import com.mooncloak.kodetools.kenv.parse.DotEnvParser
import com.mooncloak.kodetools.kenv.store.EnvironmentVariableStore
import com.mooncloak.kodetools.kenv.util.platformDefault
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toOkioPath
import okio.Path.Companion.toPath
import java.io.File

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
