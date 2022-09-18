package cz.drekorian.android.planeswalker.di

import cz.drekorian.android.planeswalker.di.module.appVanillaModule
import cz.drekorian.android.planeswalker.scryfall.di.scryfallModule

internal val modules = listOf(
    appBaseModule,
    appVanillaModule,
    scryfallModule,
)
