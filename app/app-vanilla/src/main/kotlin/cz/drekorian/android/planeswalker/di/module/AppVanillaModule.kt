package cz.drekorian.android.planeswalker.di.module

import coil.Coil
import cz.drekorian.android.planeswalker.card.CardViewModel
import cz.drekorian.android.planeswalker.lifecounter.LifeCounterViewModel
import cz.drekorian.android.planeswalker.main.MainViewModel
import cz.drekorian.android.planeswalker.set.SetViewModel
import cz.drekorian.android.planeswalker.set.list.SetListViewModel
import cz.drekorian.android.planeswalker.settings.SettingsViewModel
import cz.drekorian.android.planeswalker.settings.life.SettingsLifeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * This module provides vanilla flavor dependencies.
 */
val appVanillaModule = module {

    single { Coil }

    viewModelOf(::CardViewModel)
    viewModelOf(::LifeCounterViewModel)
    viewModelOf(::MainViewModel)
    viewModelOf(::SettingsLifeViewModel)
    viewModelOf(::SettingsViewModel)
    viewModelOf(::SettingsViewModel)
    viewModelOf(::SetListViewModel)
    viewModelOf(::SetViewModel)
}
