package cz.drekorian.android.planeswalker.settings

import android.os.Bundle
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.activity.BaseActivity

/**
 * This activity displays the hosts the Scryfall UI navigation component fragments.
 *
 * @see cz.drekorian.android.planeswalker.settings.SettingsFragment
 * @see cz.drekorian.android.planeswalker.settings.life.SettingsLifeFragment
 * @see cz.drekorian.android.planeswalker.R.navigation.navigation_settings
 */
class SettingsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
}
