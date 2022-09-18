package cz.drekorian.android.planeswalker.settings

import androidx.appcompat.app.AppCompatDelegate

/**
 * This class handles switching application themes.
 *
 * @author Marek Osvald
 */
class ThemeHelper {

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
