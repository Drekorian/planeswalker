@file:Suppress("DSL_SCOPE_VIOLATION")

buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://kotlin.bintray.com/kotlinx/") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${libs.versions.androidGradlePlugin.get()}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${libs.versions.androidx.navigation.get()}")
    }
}

plugins {
    kotlin("plugin.serialization") version libs.versions.kotlin.get() apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://kotlin.bintray.com/kotlinx/") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
