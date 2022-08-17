plugins {
    kotlin("android")
    kotlin("kapt")
    id("com.android.library")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    buildToolsVersion = libs.versions.buildTools.get()
    compileSdk = libs.versions.compileSdk.get().toInt()

    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFile("proguard-rules.pro")
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

    // module APIs
    api(project(":core"))
    api(project(":scryfall:scryfall-api"))

    // AndroidX dependencies
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintLayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.lifecycle.extensions)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Dagger dependencies
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    api(libs.kotlin.stdlib)
    implementation(libs.coil)
    implementation(libs.coil.svg)
    implementation(libs.material)
    implementation(libs.threeTenAbp)

    // test dependencies
    testImplementation(libs.junit)
}
