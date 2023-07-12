@file:Suppress("MemberVisibilityCanBePrivate")

package com.mooncloak.kodetools.kenv.buildSrc

object LibraryConstants {

    const val group = "com.mooncloak.kodetools.kenv"
    const val owner = "mooncloak.kodetools"
    const val repoName = "kenv"
    const val versionName = "1.0.0-SNAPSHOT"
    const val versionCode = 1
    const val versionDescription = "Release $versionName ($versionCode)"
    const val license = "Apache-2.0"
    const val vcsUrl = "https://github.com/mooncloak/kenv.git"

    object Android {

        const val compileSdkVersion = 33
        const val minSdkVersion = 21
        const val targetSdkVersion = 33
    }
}
