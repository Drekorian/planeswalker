package cz.drekorian.android.planeswalker.di

import cz.drekorian.android.planeswalker.base.activity.BaseActivity
import cz.drekorian.android.planeswalker.base.fragment.BaseFragment
import cz.drekorian.android.planeswalker.card.CardFragment
import cz.drekorian.android.planeswalker.core.ModuleInitializer
import cz.drekorian.android.planeswalker.main.MainActivity
import cz.drekorian.android.planeswalker.main.MainFragment
import cz.drekorian.android.planeswalker.scryfall.api.ScryfallApi
import cz.drekorian.android.planeswalker.settings.SettingsManager

/**
 * This interface provides common interface for application components.
 *
 * @author Marek Osvald
 */
interface BaseAppComponent {

    fun moduleInitializer(): ModuleInitializer
    fun settingsManager(): SettingsManager
    fun scryfallApi(): ScryfallApi

    // base
    fun injectBaseActivity(activity: BaseActivity)
    fun injectBaseFragment(fragment: BaseFragment)

    // activities
    fun injectMainActivity(activity: MainActivity)

    // fragments
    fun injectMainFragment(fragment: MainFragment)
    fun injectCardFragment(fragment: CardFragment)
}
