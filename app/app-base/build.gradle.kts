plugins {
    id("com.android.library")
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
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"
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
    api(project(":svg:svg-api"))
    api(project(":scryfall:scryfall-api"))

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

    api(Dependencies.KOTLIN_STDLIB)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.PICASSO)
    implementation(Dependencies.THREE_TEN_ABP)

    // test dependencies
    testImplementation(Dependencies.JUNIT)
}
