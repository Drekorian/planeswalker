@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    kotlin("android")
}

kotlin {
    jvmToolchain(JavaVersion.VERSION_17.majorVersion.toInt())
}

android {
    buildToolsVersion = libs.versions.buildTools.get()
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "cz.drekorian.android.planeswalker.core"

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {

    // testing dependencies
    testImplementation(libs.junit)
}
