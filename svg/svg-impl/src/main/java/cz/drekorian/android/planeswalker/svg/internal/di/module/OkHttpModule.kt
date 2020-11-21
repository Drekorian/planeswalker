package cz.drekorian.android.planeswalker.svg.internal.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * This module provides OkHttp-related dependencies.
 *
 * @author Marek Osvald
 */
@Module
internal class OkHttpModule {

    @Provides
    @Singleton
    fun provideOkHttp(application: Application): OkHttpClient = OkHttpClient.Builder()
        .cache(Cache(application.cacheDir, CACHE_SIZE.megabytes))
        .build()

    private val Long.megabytes: Long
        get() = this * 1024 * 1024

    companion object {

        /**
         * Size of OkHttp cache for SVG images.
         */
        private const val CACHE_SIZE = 5L // megabytes
    }
}
