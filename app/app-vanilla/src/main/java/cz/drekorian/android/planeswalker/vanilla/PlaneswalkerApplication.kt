package cz.drekorian.android.planeswalker.vanilla

import cz.drekorian.android.planeswalker.base.BaseApplication
import cz.drekorian.android.planeswalker.base.di.BaseAppComponentHolder
import cz.drekorian.android.planeswalker.di.DaggerAppComponent

/**
 * This class serves as the [BaseApplication] implementation for the vanilla build.
 *
 * @author Marek Osvald
 */
class PlaneswalkerApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        BaseAppComponentHolder.component = DaggerAppComponent.builder()
            .application(this)
            .build()

        BaseAppComponentHolder.component.moduleInitializer().initializeEager(this)
    }
}
