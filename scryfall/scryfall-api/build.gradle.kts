plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)
    buildToolsVersion = Versions.BUILD_TOOLS

    defaultConfig {
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
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
    api(Dependencies.AndroidX.APPCOMPAT)

    api(Dependencies.KOTLIN_STDLIB)
    api(Dependencies.THREE_TEN_ABP)
    implementation(Dependencies.MOSHI)

    // testing dependencies
    testImplementation(Dependencies.JUNIT)
}
