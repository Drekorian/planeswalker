package cz.drekorian.android.planeswalker.di

import android.app.Application
import cz.drekorian.android.planeswalker.di.module.InitializerModule
import cz.drekorian.android.planeswalker.di.module.PicassoModule
import cz.drekorian.android.planeswalker.di.module.ViewModelModule
import cz.drekorian.android.planeswalker.scryfall.di.ScryfallModule
import cz.drekorian.android.planeswalker.svg.di.module.SvgModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * This component provides dependencies for the vanilla build.
 *
 * @author Marek Osvald
 */
@Singleton
@Component(
    modules = [
        InitializerModule::class,
        PicassoModule::class,
        ScryfallModule::class,
        SvgModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : BaseAppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}
