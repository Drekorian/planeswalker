@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    buildToolsVersion = libs.versions.buildTools.get()
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "cz.drekorian.android.planeswalker.scryfall.impl"

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
        )
    }

    dependencies {

        // propagate API module up
        api(project(":scryfall:scryfall-api"))

        // Koin dependencies
        implementation(libs.koin.android)

        implementation(libs.kotlinx.datetime)
        implementation(libs.kotlinx.serialization.json)

        // Retrofit dependencies
        implementation(libs.retrofit)
        implementation(libs.retrofit.kotlinx.serialization)

        // testing dependencies
        testImplementation(libs.junit)
    }
}
