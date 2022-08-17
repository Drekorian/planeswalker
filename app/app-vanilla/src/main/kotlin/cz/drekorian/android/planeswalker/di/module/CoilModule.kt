package cz.drekorian.android.planeswalker.di.module

import coil.Coil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This module provides Coil-related dependencies.
 */
@Module
class CoilModule {

    @Provides
    @Singleton
    fun provideCoil(): Coil = Coil
}
