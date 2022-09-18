package cz.drekorian.android.planeswalker.di

import cz.drekorian.android.planeswalker.card.CardFlipHelper
import cz.drekorian.android.planeswalker.settings.SettingsManager
import cz.drekorian.android.planeswalker.settings.ThemeHelper
import org.koin.dsl.module

val appBaseModule = module {

    factory { CardFlipHelper() }

    factory { SettingsManager(get()) }

    factory { ThemeHelper() }
}
