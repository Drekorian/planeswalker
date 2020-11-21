package cz.drekorian.android.planeswalker.scryfall.internal.di.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import cz.drekorian.android.planeswalker.scryfall.internal.moshi.ScryfallDateAdapter
import cz.drekorian.android.planeswalker.scryfall.internal.moshi.ScryfallSourceAdapter
import cz.drekorian.android.planeswalker.scryfall.internal.retrofit.LiveDataCallAdapterFactory
import cz.drekorian.android.planeswalker.scryfall.internal.retrofit.ScryfallService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

/**
 * This module provides Retrofit-related dependencies.
 *
 * @author Marek Osvald
 */
@Module
internal class RetrofitModule {

    @Provides
    @Singleton
    fun provideMoshi(
        scryfallDateAdapter: ScryfallDateAdapter,
        scryfallSourceAdapter: ScryfallSourceAdapter
    ): Moshi = Moshi.Builder()
        .add(scryfallDateAdapter)
        .add(scryfallSourceAdapter)
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(liveDataCallAdapterFactory: LiveDataCallAdapterFactory, moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.scryfall.com")
        .addCallAdapterFactory(liveDataCallAdapterFactory)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @Singleton
    fun provideScryfallService(retrofit: Retrofit): ScryfallService =
        retrofit.create(ScryfallService::class.java)
}
