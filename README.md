# kenv

Kotlin Multiplatform environment variable access. This project is a port of
the [Ruby dotenv](https://github.com/bkeepers/dotenv) project for Kotlin multiplatform. It allows loading environment
variables from `.env` files, the platform's `System`, or from anywhere else.

```kotlin
val kenv = Kenv {
    system()
    dotenv(path = "./.env")
}

val value = kenv["MY_ENVIRONMENT_VARIABLE"]
```

<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/mooncloak/kenv">

## Getting Started 🏁

The library is provided through Maven Central. Checkout
the [releases page](https://github.com/mooncloak/kenv/releases) to get the latest version.
<br/><br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/mooncloak/kenv">

### Repository

```groovy
repositories {
    mavenCentral()
}
```

### Dependencies

```groovy
implementation("com.mooncloak.kenv:kenv-core:VERSION")
```

## Supported DotEnv Format 📄

`.env`, or "dotenv", files contain key-value pairs of environment variables in a format that is similar to Bash files
that exported environment variables. This project supports a format that may slightly deviate from other formats
supported by other "dotenv" libraries, but should generally be very similar. However, other than slight differences, the
concept remains the same: to simply store environment variables in a file and access those environment variables when
needed.

The variation of the "dotenv" file format that this library supports is described below.

### Key-value pairs

Environment variables are stored in a "dotenv" file as key-value pairs where the key and value are separated via an
equals signe (`=`):

```
KEY=VALUE
AUTH_TOKEN=SOME_SECRET_VALUE
```

### export statements

Before the key of an environment variable, the `export` modifier may optionally be provided. This allows these files to
be sourced in Bash.

```
export KEY=VALUE
export AUTH_TOKEN=SOME_SECRET_VALUE
```

### Keys

Environment variable keys must consist only of letters (defined
by [Char.isLetter](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/is-letter.html)), numbers (defined
by [Char.isDigit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/is-digit.html)), underscores, and periods. A
key must start with either a letter or an underscore.

### Values

A supported environment variable value must meet the following criteria:

* MUST be either a single line or multiline value.
* MAY contain whitespace (that will be trimmed) between the separating equals sign and the start of the value.
* A single line value MAY be quoted with single or double quotes.
* A single line value that is not surrounded with quotes is terminated by the first whitespace character or the end of
  the line.
* A single line value that is surrounded with quotation marks, MAY contain whitespace characters and is terminated by
  the first non-escaped (preceded by a backslash) matching quotation mark, or the end of the line.
* A multiline value begins MUST start and end with three matching, single or double quotation marks.
* A multiline value MAY consist of multiple lines of content, including whitespaces.
* A multiline value is terminated by a quotation mark set that matches its starting quotation mark set.
* An environment variable value, single line or multiline, surrounded with double quotation marks, MAY contain
  environment variables references (more on this later).

```
NO_QUOTES=abc123

REFERENCED="Inline multiple lines with the\n newline character, and substitue the following with the reference value: ${SIMPLE}"

NON_INTERPOLATED='Raw text without variable interpolation. The following does not get substituted with the referenced value: ${NO_SUB}'

MULTILINE = """
long text here,
e.g. a private SSH key
"""
```

#### References and Interpolation

Environment variable values may reference previously defined environment variables from the same "dotenv" file. As long
as the value is NOT surrounded with single quotation marks, then the referenced environment variables will be replaced
with their actual values, or `null` if the value was not found. Environment variable references take the following
format: `${REFERENCED_VARIABLE_KEY}`.

**Note:** If an environment variable reference is escaped (preceded by a backslash), then it will be ignored.

```
USER=admin
EMAIL=${USER}@example.org
DATABASE_URL="postgres://${USER}@localhost/my_database"
```

### Comments

Commented lines are ignored during parsing of the "dotenv" files. These lines start with either

* A hash symbol - `#`
* Two forward slashes - `//`
* A forward slash and an asterisk - `/*`
* An asterisk - `*`

The reason all these values are supported as starting line comments, is that it allows for the usage of both typical "
dotenv" style line comments (`#`), and for Kotlin-esque style comments, including multiline comments.

```
/**
 * WARNING: Do not check this file into version control!
 * 
 * It contains environment variables which should be kept secret.
 */

# The following contains username and password to access the repository:
repoUser=username
repoPassword=secretPassword

// TODO: Add required environment variables as needed.
```

## Usage 👨‍💻

### Kenv

Environment variables are accessed through the `EnvironmentVariableStore` component. `EnvironmentVariableStores` can be
created to retrieve environment variables from the `System`, "dotenv" files, custom sources, or a combination of all of
them. The `Kenv` class is an `EnvironemntVariableStore` instance that can easily be created and delegates to others
sources defined during its construction. To construct a `Kenv` instance, use the `Kenv` constructor function:

```kotlin
val kenv = Kenv {
    system()
    dotenv(path = "./.env")
}
```

The `Kenv` constructor function accepts a scoped builder function (`builder: KenvBuilder.() -> Unit`) as a parameter
that is used to establish the sources of environment variables. The core functions that are available to add environment
variable sources can be found on
the [KenvBuild class](/docs/kenv-core/kenv-core/com.mooncloak.kodetools.kenv/-kenv-builder/index.md).

### Order matters

The order in which these sources are established matters, as when attempting to retrieve an
environment variable via a key, the resulting `Kenv` instance will work its way backwards through the sources until it
retrieves a result. For the example above, the "dotenv" file located at the relative path "./.env" will be checked first
for an environment variable, and if it did not contain the desired variable, the system will then be checked.

### Access

Once you have a `Kenv` instance, or any other `EnvironmentVariableStore` instance, you can access the environment
variables via the [get](/docs/kenv-core/kenv-core/com.mooncloak.kodetools.kenv.store/-environment-variable-store/get.md)
function by passing in the key to the environment variable.

```kotlin
val value = kenv.get("key") // Or, kenv["key"] since `get` is the get operator function.
```

This will return an
[EnvironmentVariable.Value](/docs/kenv-core/kenv-core/com.mooncloak.kodetools.kenv/-environment-variable/-value/index.md)
instance, whose `String` value can be retrieved via the `value` property.

```kotlin 
val value: EnvironmentVariable.Value = kenv["key"]
val stringValue = value.value
```

#### Typed Values

For convenience, there are functions to obtain and convert environment variables to their desired type:

```kotlin
val secret = kenv.getString("secret")
val isDebug = kenv.getBooleanOrNull("is_debug") ?: false
val appName = kenv.getStringOrDefault("app_name", defaultValue = "MyApp")
```

#### Delegation

There are convenience functions that are available to use Kotlin delegated properties to access environment variables:

```kotlin
val secret by kenv.stringOrNull()
val isDebug by kenv.boolean("is_debug")
val appName by kenv.string("app_name", defaultValue = "MyApp")
```

### System

The `System` component can also be used directly to obtain environment variables from the underlying platform's system
component.

```kotlin
System.getEnv("access_token")
```

## Inspiration 🧠

This project was inspired by, yet completely independent of, the following open source projects:

| Project                                                     | Language   | License                                                                      |
|-------------------------------------------------------------|------------|------------------------------------------------------------------------------|
| [dotenv](https://github.com/bkeepers/dotenv)                | Ruby       | [MIT](https://github.com/bkeepers/dotenv/blob/master/LICENSE)                |
| [dotenv-kotlin](https://github.com/cdimascio/dotenv-kotlin) | Kotlin JVM | [Apache 2.0](https://github.com/cdimascio/dotenv-kotlin/blob/master/LICENSE) |
| [dotenvy](https://github.com/allan2/dotenvy)                | Rust       | [MIT](https://github.com/allan2/dotenvy/blob/master/LICENSE)                 |

## Documentation 📃

More detailed documentation is available in the [docs](docs/) folder. The entry point to the documentation can be
found [here](docs/index.md).

## Security 🛡️

For security vulnerabilities, concerns, or issues, please refer to the [security policy](SECURITY.md) for more
information on appropriate approaches for disclosure.

## Contributing ✍️

Outside contributions are welcome for this project. Please follow the [code of conduct](CODE_OF_CONDUCT.md)
and [coding conventions](CODING_CONVENTIONS.md) when contributing. If contributing code, please add thorough documents
and tests. Thank you!

## License ⚖️

```
Copyright 2023 mooncloak

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
