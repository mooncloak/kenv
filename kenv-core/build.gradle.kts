import com.mooncloak.kodetools.kenv.buildSrc.LibraryConstants
import com.mooncloak.kodetools.kenv.buildSrc.isBuildingOnLinux
import com.mooncloak.kodetools.kenv.buildSrc.isBuildingOnOSX
import com.mooncloak.kodetools.kenv.buildSrc.isBuildingOnWindows
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
    id("org.jetbrains.dokka")
    id("com.mikepenz.aboutlibraries.plugin")
}

group = LibraryConstants.group
version = LibraryConstants.versionName

kotlin {
    // Enable the default target hierarchy:
    applyDefaultHierarchyTemplate()

    jvm()

    js(IR) {
        nodejs()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        nodejs {
            testTask {
                enabled = false
            }
        }
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmWasi()

    androidTarget {
        publishAllLibraryVariants()
    }

    if (isBuildingOnOSX()) {
        iosX64()
        iosArm64()
        iosSimulatorArm64()
        tvosX64()
        tvosArm64()
        watchosX64()
        watchosArm64()
        macosX64()
        macosArm64()
    }

    if (isBuildingOnLinux()) {
        linuxX64()
    }

    if (isBuildingOnWindows()) {
        mingwX64()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("com.squareup.okio:okio:_")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jsMain by getting {
            dependencies {
                implementation("com.squareup.okio:okio-nodefilesystem:_")
            }
        }

        val wasmJsMain by getting

        val wasmWasiMain by getting {
            dependencies {
                implementation("com.squareup.okio:okio-wasifilesystem:_")
            }
        }

        val nativeMain by getting
    }
}

android {
    namespace = "com.mooncloak.kodetools.kenv"
    compileSdk = LibraryConstants.Android.compileSdkVersion

    defaultConfig {
        minSdk = LibraryConstants.Android.minSdkVersion
        targetSdk = LibraryConstants.Android.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            // Opt-in to experimental compose APIs
            freeCompilerArgs = listOf(
                "-Xopt-in=kotlin.RequiresOptIn"
            )
        }
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].java.srcDirs("src/androidMain/kotlin")
    sourceSets["main"].res.srcDirs("src/androidMain/res")

    sourceSets["test"].java.srcDirs("src/androidTest/kotlin")
    sourceSets["test"].res.srcDirs("src/androidTest/res")
}

tasks.withType<Jar> { duplicatesStrategy = DuplicatesStrategy.INHERIT }

aboutLibraries {
    // - If the automatic registered android tasks are disabled, a similar thing can be achieved manually
    // - `./gradlew app:exportLibraryDefinitions -PaboutLibraries.exportPath=src/main/res/raw`
    // - the resulting file can for example be added as part of the SCM
    registerAndroidTasks = false

    // Define the output file name. Modifying this will disable the automatic meta data discovery for supported platforms.
    outputFileName = "dependencies.json"

    // Enable pretty printing for the generated JSON file
    prettyPrint = true

    // Allows to only collect dependencies of specific variants during the `collectDependencies` step.
    filterVariants += "release"
}

afterEvaluate {
    publishing {
        repositories {
            maven {
                url = uri("https://maven.pkg.jetbrains.space/mooncloak/p/main/kodetools")

                val usernameKey = "spaceUsername"
                val passwordKey = "spacePassword"

                credentials {
                    username = (project.findProperty(usernameKey) ?: System.getenv(usernameKey)) as? String
                    password = (project.findProperty(passwordKey) ?: System.getenv(passwordKey)) as? String
                }
            }
        }
    }
}
