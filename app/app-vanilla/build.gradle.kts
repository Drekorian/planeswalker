plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    buildToolsVersion = libs.versions.buildTools.get()
    compileSdk = libs.versions.compileSdk.get().toInt()

    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        applicationId = "cz.drekorian.android.planeswalker"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
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

    // local dependencies
    implementation(project(":app:app-base"))
    implementation(project(":scryfall:scryfall-impl"))

    // AndroidX dependencies
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.constraintLayout)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.lifecycle.extensions)
    implementation(libs.androidx.navigation.ui.ktx)

    // Dagger dependencies
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.kotlin.stdlib)
    implementation(libs.coil)
    implementation(libs.material)
    implementation(libs.threeTenAbp)

    // test dependencies
    testImplementation(libs.junit)
}
