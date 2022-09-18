package cz.drekorian.android.planeswalker.vanilla

import cz.drekorian.android.planeswalker.base.BaseApplication
import cz.drekorian.android.planeswalker.di.modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * This class serves as the [BaseApplication] implementation for the vanilla build.
 *
 * @author Marek Osvald
 */
class PlaneswalkerApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PlaneswalkerApplication)
            modules(modules)
        }
    }
}
