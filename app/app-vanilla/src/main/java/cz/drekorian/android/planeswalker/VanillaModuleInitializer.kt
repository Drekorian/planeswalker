package cz.drekorian.android.planeswalker

import android.app.Application
import cz.drekorian.android.planeswalker.core.ModuleInitializer
import javax.inject.Inject

/**
 * This class initializes dependency modules for the vanilla build.
 *
 * @author Marek Osvald
 */
class VanillaModuleInitializer @Inject constructor(
    private val moduleConfig: VanillaModuleConfig
) : ModuleInitializer {

    override fun initializeEager(application: Application) {
        moduleConfig.moduleInitializers.forEach { module -> module.initializeEager(application) }
    }

    override fun initializeLazy(application: Application) {
        moduleConfig.moduleInitializers.forEach { module -> module.initializeLazy(application) }
    }
}
