package cz.drekorian.android.planeswalker.scryfall.di

import cz.drekorian.android.planeswalker.scryfall.Scryfall
import cz.drekorian.android.planeswalker.scryfall.api.ScryfallApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This module provides Scryfall-related dependencies.
 *
 * @author Marek Osvald
 */
@Module
class ScryfallModule {

    @Singleton
    @Provides
    fun provideScryfallApi(): ScryfallApi = Scryfall
}
