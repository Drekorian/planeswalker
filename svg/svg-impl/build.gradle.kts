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

    // propagate API modules up
    api(project(":svg:svg-api"))

    // Dagger dependencies
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.kotlin.stdlib)
    implementation(libs.okhttp)
    implementation(libs.sharp)

    // testing dependencies
    testImplementation(libs.junit)
}
