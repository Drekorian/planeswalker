/**
 * This object stores module dependencies.
 *
 * @author Marek Osvald
 */
object Dependencies {

    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val MOSHI = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val PICASSO = "com.squareup.picasso:picasso:${Versions.PICASSO}"
    const val SHARP = "com.pixplicity.sharp:library:${Versions.SHARP}"
    const val THREE_TEN_ABP = "com.jakewharton.threetenabp:threetenabp:${Versions.THREE_TEN_ABP}"

    object AndroidX {
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APPCOMPAT}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.AndroidX.CORE_KTX}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.CONSTRAINT_LAYOUT}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.AndroidX.FRAGMENT_KTX}"
        const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.LIFECYCLE_EXTENSIONS}"
        const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.NAVIGATION}"
        const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.NAVIGATION}"
        const val NAVIGATION_SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.AndroidX.NAVIGATION}"
    }

    object Dagger {
        const val DAGGER = "com.google.dagger:dagger-android:${Versions.DAGGER}"
        const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
    }

    object Retrofit {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val RETROFIT_MOSHI = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"
        const val RETROFIT_SCALARS = "com.squareup.retrofit2:converter-scalars:${Versions.RETROFIT}"
    }
}
