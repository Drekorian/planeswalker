package cz.drekorian.android.planeswalker.vanilla

import coil.Coil
import coil.ImageLoader
import cz.drekorian.android.planeswalker.base.BaseApplication
import cz.drekorian.android.planeswalker.di.modules
import okhttp3.OkHttpClient
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

        val koinApplication = startKoin {
            androidLogger()
            androidContext(this@PlaneswalkerApplication)
            modules(modules)
        }

        Coil.setImageLoader {
            ImageLoader.Builder(this@PlaneswalkerApplication)
                .okHttpClient(koinApplication.koin.get<OkHttpClient>())
                .build()
        }
    }
}
