package com.mooncloak.kodetools.kenv.exception

/**
 * An [Exception] that is thrown when attempting to retrieve an environment variable that does not exist.
 */
class NoSuchEnvironmentVariableException(
    message: String? = null,
    cause: Throwable? = null
) : RuntimeException(message, cause) {

    constructor(key: String) : this("No environment variable found in 'EnvironmentVariableStore' for '$key'.", null)
}
