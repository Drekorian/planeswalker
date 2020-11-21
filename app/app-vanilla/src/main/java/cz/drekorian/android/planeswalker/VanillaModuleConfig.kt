package cz.drekorian.android.planeswalker

import cz.drekorian.android.planeswalker.core.ModuleInitializer
import cz.drekorian.android.planeswalker.scryfall.ScryfallInitializer
import cz.drekorian.android.planeswalker.svg.SvgInitializer
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This singleton stores module initializers for vanilla build.
 *
 * @author Marek Osvald
 */
@Singleton
class VanillaModuleConfig @Inject constructor() {

    /**
     * Stores module initializers of modules to initialize in the vanilla build.
     */
    val moduleInitializers: Set<ModuleInitializer> = setOf(ScryfallInitializer, SvgInitializer)
}
