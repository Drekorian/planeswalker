package cz.drekorian.android.planeswalker.svg.internal.di

import android.app.Application
import cz.drekorian.android.planeswalker.svg.internal.Svg
import cz.drekorian.android.planeswalker.svg.internal.di.module.OkHttpModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * This component provides internal dependencies for the SVG module.
 *
 * @author Marek Osvald
 */
@Singleton
@Component(modules = [OkHttpModule::class])
internal interface SvgComponent {

    fun svg(): Svg

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): SvgComponent
    }
}
