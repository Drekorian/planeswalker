package cz.drekorian.android.planeswalker.scryfall.internal.di

import android.app.Application
import cz.drekorian.android.planeswalker.scryfall.internal.di.module.RetrofitModule
import cz.drekorian.android.planeswalker.scryfall.internal.retrofit.ScryfallService
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * This component provides internal dependencies fot the Scryfall module.
 *
 * @author Marek Osvald
 */
@Singleton
@Component(
    modules = [
        RetrofitModule::class
    ]
)
interface ScryfallComponent {

    fun retrofit(): Retrofit
    fun scryfallService(): ScryfallService

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ScryfallComponent
    }
}
