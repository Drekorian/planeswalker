package cz.drekorian.android.planeswalker.settings

import android.app.Application
import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This singleton handles user settings and their persistence.
 *
 * @author Marek Osvald
 */
@Singleton
class SettingsManager @Inject constructor(application: Application) {

    private val preferences =
        application.getSharedPreferences(PREFERENCES_NAME_SETTINGS, Context.MODE_PRIVATE)

    /**
     * Stores whether Dark mode is enforced or not.
     */
    var isDarkMode: Boolean
        get() = preferences.getBoolean(KEY_DARK_MODE, false)
        set(value) = preferences.edit(commit = true) { putBoolean(KEY_DARK_MODE, value) }

    /**
     * Stores default life count for life counter.
     */
    var defaultLifeCount: Int
        get() = preferences.getInt(KEY_DEFAULT_LIFE_COUNT, DEFAULT_LIFE_COUNT_STANDARD)
        set(value) {
            require(value in ALLOWED_LIFE_COUNTS) { "Invalid life count: $value." }
            preferences.edit(commit = true) { putInt(KEY_DEFAULT_LIFE_COUNT, value) }
        }

    companion object {

        private const val PREFERENCES_NAME_SETTINGS = "prefs_settings"
        private const val KEY_DARK_MODE = "dark_mode"
        private const val KEY_DEFAULT_LIFE_COUNT = "default_life_count"

        /**
         * Stores default life count for Standard Magic game.
         */
        const val DEFAULT_LIFE_COUNT_STANDARD = 20

        /**
         * Stores default life count for Brawl Magic game.
         */
        const val DEFAULT_LIFE_COUNT_BRAWL = 25

        /**
         * Stores default life count for Commander Magic game.
         */
        const val DEFAULT_LIFE_COUNT_COMMANDER = 40

        /**
         * This set stores allowed default life counts.
         */
        val ALLOWED_LIFE_COUNTS = setOf(
            DEFAULT_LIFE_COUNT_STANDARD,
            DEFAULT_LIFE_COUNT_BRAWL,
            DEFAULT_LIFE_COUNT_COMMANDER
        )
    }
}
