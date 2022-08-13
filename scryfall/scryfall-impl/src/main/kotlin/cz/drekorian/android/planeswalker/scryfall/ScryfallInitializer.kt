package cz.drekorian.android.planeswalker.scryfall

import android.app.Application
import cz.drekorian.android.planeswalker.core.ModuleInitializer
import cz.drekorian.android.planeswalker.scryfall.internal.di.DaggerScryfallComponent
import cz.drekorian.android.planeswalker.scryfall.internal.di.ScryfallComponentHolder

/**
 * This object initializes the Scryfall module.
 *
 * @author Marek Osvald
 */
object ScryfallInitializer : ModuleInitializer {

    override fun initializeLazy(application: Application) {
        ScryfallComponentHolder.component = DaggerScryfallComponent.builder()
            .application(application)
            .build()
    }
}
