package cz.drekorian.android.planeswalker.main

import android.os.Bundle
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.activity.BaseActivity
import cz.drekorian.android.planeswalker.base.di.BaseAppComponentHolder
import cz.drekorian.android.planeswalker.core.ModuleInitializer
import cz.drekorian.android.planeswalker.settings.SettingsManager
import cz.drekorian.android.planeswalker.settings.ThemeHelper
import javax.inject.Inject

/**
 * This activity displays the hosts of the main UI navigation component fragments.
 *
 * @see MainFragment
 * @see R.navigation.navigation_main
 */
class MainActivity : BaseActivity() {

    @Inject
    lateinit var moduleInitializer: ModuleInitializer

    @Inject
    lateinit var settingsManager: SettingsManager

    @Inject
    lateinit var themeHelper: ThemeHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moduleInitializer.initializeLazy(application)
        themeHelper.enforceDarkMode(settingsManager.isDarkMode)
    }

    override fun inject() {
        BaseAppComponentHolder.component.injectMainActivity(this)
    }
}
