package cz.drekorian.android.planeswalker.di.module

import cz.drekorian.android.planeswalker.VanillaModuleInitializer
import cz.drekorian.android.planeswalker.core.ModuleInitializer
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * This module provides dependency module-related dependencies.
 *
 * @author Marek Osvald
 */
@Module
interface InitializerModule {

    @Binds
    @Singleton
    fun bindModuleInitializer(vanillaModuleInitializer: VanillaModuleInitializer): ModuleInitializer
}
