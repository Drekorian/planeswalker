plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)
    buildToolsVersion = Versions.BUILD_TOOLS

    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        applicationId = "cz.drekorian.android.planeswalker"
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
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
    implementation(project(":svg:svg-impl"))

    // AndroidX dependencies
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependencies.AndroidX.FRAGMENT_KTX)
    implementation(Dependencies.AndroidX.NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.AndroidX.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.AndroidX.NAVIGATION_UI_KTX)

    // Dagger dependencies
    implementation(Dependencies.Dagger.DAGGER)
    kapt(Dependencies.Dagger.DAGGER_COMPILER)

    implementation(Dependencies.KOTLIN_STDLIB)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.PICASSO)
    implementation(Dependencies.THREE_TEN_ABP)

    // test dependencies
    testImplementation(Dependencies.JUNIT)
}
