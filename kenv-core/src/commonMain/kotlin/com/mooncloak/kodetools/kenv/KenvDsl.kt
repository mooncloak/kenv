@file:Suppress("unused", "KotlinRedundantDiagnosticSuppress", "NOTHING_TO_INLINE")

package com.mooncloak.kodetools.kenv

import com.mooncloak.kodetools.kenv.parse.DotEnvParser
import com.mooncloak.kodetools.kenv.store.DotEnvEnvironmentVariableStore
import com.mooncloak.kodetools.kenv.store.EnvironmentVariableStore
import com.mooncloak.kodetools.kenv.store.InMemoryEnvironmentVariableStore
import com.mooncloak.kodetools.kenv.util.bufferedAsUtf8
import com.mooncloak.kodetools.kenv.util.platformDefault
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import okio.Source

/**
 * Constructs an instance of the [Kenv] class using the [EnvironmentVariableStore]s from the provided [builder]
 * function. The [EnvironmentVariableStore]s are applied in order where subsequently applied
 * [EnvironmentVariableStore]s override existing variables from previously applied [EnvironmentVariableStore]s with the
 * same key. That is, when attempting to access an environment variable from the resulting [Kenv] instance, the
 * [EnvironmentVariableStore]s will be searched in reverse order that they are applied here until an environment
 * variable with the matching key is found. This creates a cascading effect where environment variables can be
 * overridden by other values applied. For instance, consider having a default ".env" file and an optionally applied
 * ".development.env" file which is only applied when in development but overrides the values in ".env" when it is
 * applied.
 *
 * ## Example Usage
 *
 * ```kotlin
 * val kenv = Kenv {
 *     system()
 *     dotenv("./.env") // Matching keys will override values from the `System` environment variable store.
 * }
 * ```
 *
 * @return A [Kenv] instance constructed using the [EnvironmentVariableStore] values provided in the [builder]
 * function.
 */
fun Kenv(builder: KenvBuilder.() -> Unit): Kenv {
    val kenvBuilder = KenvBuilder()

    kenvBuilder.builder()

    return kenvBuilder.build()
}

/**
 * A class that is used to construct a [Kenv] instance. The functions within this class add [EnvironmentVariableStore]s
 * to a list that are used to construct the [Kenv] instance. The order in which the functions are invoked matter,
 * because [EnvironmentVariableStore] applied will override previously applied [EnvironmentVariableStore]s if they
 * contain environment variables with the same key.
 */
class KenvBuilder internal constructor() {

    private val stores = mutableListOf<EnvironmentVariableStore>()

    /**
     * Adds the provided [EnvironmentVariableStore] to the [Kenv] instance being created in the order this function is
     * invoked.
     *
     * @param [store] The [EnvironmentVariableStore] to add.
     */
    fun store(store: EnvironmentVariableStore) {
        stores.add(store)
    }

    /**
     * Adds the [System] [EnvironmentVariableStore] to the [Kenv] instance being created in the order this function is
     * invoked.
     */
    fun system() {
        stores.add(System)
    }

    /**
     * Creates an [EnvironmentVariableStore] wrapping the provided [variables] and adds it to the [Kenv] instance being
     * created in the order this function is invoked.
     *
     * @param [variables] A [Map] of [EnvironmentVariable.key] to [EnvironmentVariable]s which are wrapped in an
     * [EnvironmentVariableStore] and added to the [Kenv] instance being created.
     */
    fun variables(variables: Map<String, EnvironmentVariable.Value>) {
        stores.add(InMemoryEnvironmentVariableStore(variables))
    }

    /**
     * Creates an [EnvironmentVariableStore] wrapping the provided [variables] and adds it to the [Kenv] instance being
     * created in the order this function is invoked.
     *
     * @param [variables] A [Collection] of [EnvironmentVariable]s which are wrapped in an [EnvironmentVariableStore]
     * and added to the [Kenv] instance being created.
     */
    fun variables(variables: Collection<EnvironmentVariable>) {
        stores.add(InMemoryEnvironmentVariableStore(variables))
    }

    /**
     * Creates an [EnvironmentVariableStore] wrapping the provided [variables] and adds it to the [Kenv] instance being
     * created in the order this function is invoked.
     *
     * @param [variables] A vararg array of [EnvironmentVariable]s which are wrapped in an [EnvironmentVariableStore]
     * and added to the [Kenv] instance being created.
     */
    fun variables(vararg variables: EnvironmentVariable) {
        stores.add(InMemoryEnvironmentVariableStore(*variables))
    }

    /**
     * Creates an [EnvironmentVariableStore] from the provided literal [String] [value] representing the contents of a
     * ".env" file and adds it to the [Kenv] instance being created in the order this function is invoked.
     *
     * @param [value] The [String] contents of a ".env" file.
     * @param [options] The [DotEnvParser.Options] used during the parsing of the ".env" file.
     */
    fun literal(
        value: String,
        options: DotEnvParser.Options = DotEnvParser.Options()
    ) {
        stores.add(DotEnvEnvironmentVariableStore(source = value.bufferedAsUtf8(), options = options))
    }

    /**
     * Creates an [EnvironmentVariableStore] from the provided [source] and adds it to the [Kenv] instance being
     * created in the order this function is invoked.
     *
     * @param [source] The [Source] of a ".env" file.
     * @param [options] The [DotEnvParser.Options] used during the parsing of the ".env" file.
     */
    fun dotenv(
        source: Source,
        options: DotEnvParser.Options = DotEnvParser.Options()
    ) {
        stores.add(DotEnvEnvironmentVariableStore(source = source, options = options))
    }

    /**
     * Creates an [EnvironmentVariableStore] from the provided ".env" file [path] and [fileSystem] and adds it to the
     * [Kenv] instance being created in the order this function is invoked.
     *
     * @param [path] The [Path] to the ".env" file.
     * @param [fileSystem] The [FileSystem] where the ".env" file resides.
     * @param [options] The [DotEnvParser.Options] used during the parsing of the ".env" file.
     */
    fun dotenv(
        path: Path,
        fileSystem: FileSystem = FileSystem.platformDefault,
        options: DotEnvParser.Options = DotEnvParser.Options()
    ) {
        stores.add(DotEnvEnvironmentVariableStore(source = fileSystem.source(file = path), options = options))
    }

    /**
     * Creates an [EnvironmentVariableStore] from the provided ".env" file [path] and [fileSystem] and adds it to
     * the [Kenv] instance being created in the order this function is invoked.
     *
     * @param [path] The [String] path to the ".env" file.
     * @param [normalize] Whether the [path] should be normalized. See [Path.Companion.toPath].
     * @param [fileSystem] The [FileSystem] where the ".env" file resides.
     * @param [options] The [DotEnvParser.Options] used during the parsing of the ".env" file.
     */
    fun dotenv(
        path: String,
        normalize: Boolean = false,
        fileSystem: FileSystem = FileSystem.platformDefault,
        options: DotEnvParser.Options = DotEnvParser.Options()
    ) {
        stores.add(
            DotEnvEnvironmentVariableStore(
                source = fileSystem.source(file = path.toPath(normalize = normalize)),
                options = options
            )
        )
    }

    /**
     * Creates the [Kenv] instance.
     */
    internal fun build(): Kenv =
        Kenv(stores = stores)
}

/**
 * A convenience function for invoking the [KenvBuilder.store] function.
 */
inline operator fun KenvBuilder.plus(store: EnvironmentVariableStore) {
    store(store = store)
}
