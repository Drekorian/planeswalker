plugins {
    kotlin("android")
    kotlin("kapt")
    id("com.android.library")
    id("androidx.navigation.safeargs.kotlin")
}

kotlin {
    jvmToolchain(JavaVersion.VERSION_17.majorVersion.toInt())
}

android {
    buildToolsVersion = libs.versions.buildTools.get()
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "cz.drekorian.android.planeswalker"

    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFile("proguard-rules.pro")
        }
    }
}

dependencies {

    // module APIs
    api(project(":core"))
    api(project(":scryfall:scryfall-api"))

    // AndroidX dependencies
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintLayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Koin dependencies
    implementation(libs.koin.android)

    api(libs.kotlin.stdlib)
    implementation(libs.coil)
    implementation(libs.coil.svg)
    implementation(libs.kotlinx.datetime)
    implementation(libs.material)

    // test dependencies
    testImplementation(libs.junit)
}
