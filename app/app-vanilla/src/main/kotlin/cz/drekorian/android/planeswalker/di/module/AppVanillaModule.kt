package cz.drekorian.android.planeswalker.di.module

import coil.Coil
import cz.drekorian.android.planeswalker.card.CardViewModel
import cz.drekorian.android.planeswalker.lifecounter.LifeCounterActivity
import cz.drekorian.android.planeswalker.lifecounter.LifeCounterViewModel
import cz.drekorian.android.planeswalker.main.MainViewModel
import cz.drekorian.android.planeswalker.set.SetViewModel
import cz.drekorian.android.planeswalker.set.list.SetListViewModel
import cz.drekorian.android.planeswalker.settings.SettingsViewModel
import cz.drekorian.android.planeswalker.settings.life.SettingsLifeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.TypeQualifier
import org.koin.dsl.module

/**
 * This module provides Coil-related dependencies.
 */
val appVanillaModule = module {

    single { Coil }

    viewModel {
        CardViewModel(get())
    }

    viewModel {
        LifeCounterViewModel(get())
    }

    viewModel {
        MainViewModel(get())
    }

    viewModel {
        SettingsLifeViewModel(get())
    }

    viewModel {
        SettingsViewModel(get(), get())
    }

    viewModel {
        SetListViewModel(get())
    }

    viewModel {
        SetViewModel(get())
    }
}
