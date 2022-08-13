package cz.drekorian.android.planeswalker.base.di

import cz.drekorian.android.planeswalker.di.BaseAppComponent

/**
 * This object holds the singleton [BaseAppComponent] instance.
 *
 * @author Marek Osvald
 */
object BaseAppComponentHolder {

    /**
     * Stores singleton [BaseAppComponent] instance.
     */
    lateinit var component: BaseAppComponent
}
