package cz.drekorian.android.planeswalker.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cz.drekorian.android.planeswalker.base.di.ViewModelFactory
import cz.drekorian.android.planeswalker.card.CardViewModel
import cz.drekorian.android.planeswalker.di.ViewModelKey
import cz.drekorian.android.planeswalker.lifecounter.LifeCounterViewModel
import cz.drekorian.android.planeswalker.main.MainViewModel
import cz.drekorian.android.planeswalker.set.SetViewModel
import cz.drekorian.android.planeswalker.set.list.SetListViewModel
import cz.drekorian.android.planeswalker.settings.SettingsViewModel
import cz.drekorian.android.planeswalker.settings.life.SettingsLifeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

/**
 * This module provides [ViewModel] dependencies.
 *
 * @author Marek Osvald
 */
@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CardViewModel::class)
    fun provideCardViewModel(viewModel: CardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LifeCounterViewModel::class)
    fun provideLifeCounterViewModel(viewModel: LifeCounterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsLifeViewModel::class)
    fun provideSettingsLifeViewModel(viewModel: SettingsLifeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    fun provideSettingsViewModel(viewModel: SettingsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SetListViewModel::class)
    fun provideSetListViewModel(viewModel: SetListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SetViewModel::class)
    fun provideSetViewModel(viewModel: SetViewModel): ViewModel

    @Binds
    @Singleton
    fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
