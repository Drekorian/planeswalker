package cz.drekorian.android.planeswalker.main

import android.os.Bundle
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.activity.BaseActivity
import cz.drekorian.android.planeswalker.settings.SettingsManager
import cz.drekorian.android.planeswalker.settings.ThemeHelper
import org.koin.android.ext.android.inject

/**
 * This activity displays the hosts of the main UI navigation component fragments.
 *
 * @see MainFragment
 * @see R.navigation.navigation_main
 */
class MainActivity : BaseActivity() {

    private val settingsManager: SettingsManager by inject()

    private val themeHelper: ThemeHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        themeHelper.enforceDarkMode(settingsManager.isDarkMode)
    }
}
