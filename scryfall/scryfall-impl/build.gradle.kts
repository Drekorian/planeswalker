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

    // propagate API module up
    api(project(":scryfall:scryfall-api"))

    // Dagger dependencies
    implementation(Dependencies.Dagger.DAGGER)
    kapt(Dependencies.Dagger.DAGGER_COMPILER)

    implementation(Dependencies.MOSHI)

    // Retrofit dependencies
    implementation(Dependencies.Retrofit.RETROFIT)
    implementation(Dependencies.Retrofit.RETROFIT_MOSHI)
    implementation(Dependencies.Retrofit.RETROFIT_SCALARS)

    // testing dependencies
    testImplementation(Dependencies.JUNIT)
}
