plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    buildToolsVersion = libs.versions.buildTools.get()
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
