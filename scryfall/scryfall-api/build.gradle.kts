@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

kotlin {
    jvmToolchain(JavaVersion.VERSION_17.majorVersion.toInt())
}

android {
    buildToolsVersion = libs.versions.buildTools.get()
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "cz.drekorian.android.planeswalker.scryfall.api"

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
        )
    }
}

dependencies {

    // propagate core module up
    api(project(":core"))

    // AndroidX dependencies
    api(libs.androidx.appcompat)

    api(libs.kotlin.stdlib)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)

    // testing dependencies
    testImplementation(libs.junit)
}
