plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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
    }
}

dependencies {

    // propagate core module up
    api(project(":core"))

    // AndroidX dependencies
    api(libs.androidx.appcompat)

    api(libs.kotlin.stdlib)
    api(libs.threeTenAbp)
    implementation(libs.moshi)

    // testing dependencies
    testImplementation(libs.junit)
}
