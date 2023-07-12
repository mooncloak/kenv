import com.mooncloak.kodetools.kenv.buildSrc.LibraryConstants
import com.mooncloak.kodetools.kenv.buildSrc.isBuildingOnLinux
import com.mooncloak.kodetools.kenv.buildSrc.isBuildingOnOSX
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
    id("org.jetbrains.dokka")
}

group = LibraryConstants.group
version = LibraryConstants.versionName

kotlin {
    jvm()

    js(IR) {
        nodejs()
    }

    androidTarget()

    if (isBuildingOnOSX()) {
        ios()
        iosSimulatorArm64()
        macosX64("native")
        macosArm64("native")
    }

    if (isBuildingOnLinux()) {
        linuxX64("native")
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

        val nativeMain by getting

        if (isBuildingOnOSX()) {
            val iosMain by sourceSets.getting
            val iosSimulatorArm64Main by sourceSets.getting
            iosSimulatorArm64Main.dependsOn(iosMain)
        }
    }
}

android {
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
