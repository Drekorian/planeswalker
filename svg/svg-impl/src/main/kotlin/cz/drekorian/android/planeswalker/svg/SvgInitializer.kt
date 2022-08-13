package cz.drekorian.android.planeswalker.svg

import android.app.Application
import cz.drekorian.android.planeswalker.core.ModuleInitializer
import cz.drekorian.android.planeswalker.svg.internal.di.DaggerSvgComponent
import cz.drekorian.android.planeswalker.svg.internal.di.SvgComponentHolder

/**
 * Initializes the SVG module.
 *
 * No eager initialization is necessary, all inicialization is done lazily.
 *
 * @author Marek Osvald
 */
object SvgInitializer : ModuleInitializer {

    override fun initializeLazy(application: Application) {
        SvgComponentHolder.component = DaggerSvgComponent.builder()
            .application(application)
            .build()
    }
}
