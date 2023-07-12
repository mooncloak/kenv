package com.mooncloak.kodetools.kenv.exception

/**
 * An exception that is thrown when an error is encountered parsing a ".env" file.
 */
class DotEnvParseException(
    message: String? = null,
    cause: Throwable? = null
) : RuntimeException(message, cause)
