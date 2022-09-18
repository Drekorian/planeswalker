package cz.drekorian.android.planeswalker.scryfall.internal.di.module

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import cz.drekorian.android.planeswalker.scryfall.internal.retrofit.LiveDataCallAdapterFactory
import cz.drekorian.android.planeswalker.scryfall.internal.retrofit.ScryfallService
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * This module provides Retrofit-related dependencies.
 *
 * @author Marek Osvald
 */
@Module
internal class RetrofitModule {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        prettyPrint = true
        useAlternativeNames = true
    }

    @Provides
    @Singleton
    fun provideRetrofit(liveDataCallAdapterFactory: LiveDataCallAdapterFactory): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.scryfall.com")
            .addCallAdapterFactory(liveDataCallAdapterFactory)
            .addConverterFactory(
                json.asConverterFactory(
                    MediaType.get("application/json")
                )
            )
            .build()

    @Provides
    @Singleton
    fun provideScryfallService(retrofit: Retrofit): ScryfallService =
        retrofit.create(ScryfallService::class.java)
}
