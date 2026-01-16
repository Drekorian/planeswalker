@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.android.legacyKapt)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(JavaVersion.VERSION_17.majorVersion.toInt())
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

    kotlin {
        compilerOptions {
            optIn.add("kotlinx.serialization.ExperimentalSerializationApi")
        }
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
