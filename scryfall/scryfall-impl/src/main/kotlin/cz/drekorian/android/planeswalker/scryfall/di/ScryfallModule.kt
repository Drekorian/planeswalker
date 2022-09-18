package cz.drekorian.android.planeswalker.scryfall.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import cz.drekorian.android.planeswalker.scryfall.Scryfall
import cz.drekorian.android.planeswalker.scryfall.api.ScryfallApi
import cz.drekorian.android.planeswalker.scryfall.internal.retrofit.LiveDataCallAdapterFactory
import cz.drekorian.android.planeswalker.scryfall.internal.retrofit.ScryfallService
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Retrofit

/**
 * This module provides Scryfall-related dependencies.
 *
 * @author Marek Osvald
 */
private val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
    prettyPrint = true
    useAlternativeNames = true
}
val scryfallModule = module {

    single<ScryfallApi> { Scryfall }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.scryfall.com")
            .addCallAdapterFactory(get())
            .addConverterFactory(
                json.asConverterFactory(
                    MediaType.get("application/json")
                )
            )
            .build()
    }

    single { LiveDataCallAdapterFactory() } bind CallAdapter.Factory::class

    single { get<Retrofit>().create(ScryfallService::class.java) }
}
