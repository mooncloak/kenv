//[kenv-core](../../index.md)/[com.mooncloak.kodetools.kenv](index.md)/[Kenv](-kenv.md)

# Kenv

[common]\
fun [Kenv](-kenv.md)(builder: [KenvBuilder](-kenv-builder/index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [Kenv](-kenv/index.md)

Constructs an instance of the [Kenv](-kenv/index.md) class using the [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md)s from the provided [builder](-kenv.md) function. The [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md)s are applied in order where subsequently applied [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md)s override existing variables from previously applied [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md)s with the same key. That is, when attempting to access an environment variable from the resulting [Kenv](-kenv/index.md) instance, the [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md)s will be searched in reverse order that they are applied here until an environment variable with the matching key is found. This creates a cascading effect where environment variables can be overridden by other values applied. For instance, consider having a default &quot;.env&quot; file and an optionally applied &quot;.development.env&quot; file which is only applied when in development but overrides the values in &quot;.env&quot; when it is applied.

## Example Usage

```kotlin
val kenv = Kenv {
    system()
    dotenv("./.env") // Matching keys will override values from the `System` environment variable store.
}
```

#### Return

A [Kenv](-kenv/index.md) instance constructed using the [EnvironmentVariableStore](../com.mooncloak.kodetools.kenv.store/-environment-variable-store/index.md) values provided in the [builder](-kenv.md) function.
