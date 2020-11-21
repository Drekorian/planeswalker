package cz.drekorian.android.planeswalker.svg.di.module

import cz.drekorian.android.planeswalker.svg.api.SvgApi
import cz.drekorian.android.planeswalker.svg.internal.di.SvgComponentHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This module provides SVG-related dependencies.
 *
 * @author Marek Osvald
 */
@Module
class SvgModule {

    @Provides
    @Singleton
    fun provideSvgApi(): SvgApi = SvgComponentHolder.component.svg()
}
