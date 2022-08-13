package cz.drekorian.android.planeswalker.settings

import androidx.appcompat.app.AppCompatDelegate
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This class handles switching application themes.
 *
 * @author Marek Osvald
 */
@Singleton
class ThemeHelper @Inject constructor() {

    /**
     * Switches theme based on the [enforceDarkMode] value.
     *
     * @param enforceDarkMode true in order to enforce Dark mode, false otherwise
     */
    fun enforceDarkMode(enforceDarkMode: Boolean) {
        AppCompatDelegate.setDefaultNightMode(
            when {
                enforceDarkMode -> AppCompatDelegate.MODE_NIGHT_YES
                else -> AppCompatDelegate.MODE_NIGHT_NO
            }
        )
    }
}
