package cz.drekorian.android.planeswalker.settings

import android.view.View
import android.widget.Checkable
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

/**
 * This [ViewModel] handles the business logic the [SettingsFragment].
 *
 * @see SettingsFragment
 * @author Marek Osvald
 */
class SettingsViewModel(
    private val settingsManager: SettingsManager,
    private val themeHelper: ThemeHelper
) : ViewModel() {

    /**
     * Stores whether Dark mode is enforced by the user.
     */
    val isDarkMode: Boolean
        get() = settingsManager.isDarkMode

    /**
     * Sets whether Dark mode should be enabled or not.
     *
     * @param view an instance of [Checkable] that stores whether the Dark mode should be enforced
     * or not in its `isChecked` property
     */
    fun setDarkMode(view: View) {
        if (view !is Checkable) {
            return
        }

        val enforceDarkMode = view.isChecked
        themeHelper.enforceDarkMode(enforceDarkMode)
        settingsManager.isDarkMode = enforceDarkMode
    }

    /**
     * Handles tapping the Life Counter action.
     *
     * @param view clicked [View] instance
     */
    fun onLifeClick(view: View) {
        view.findNavController().navigate(SettingsFragmentDirections.showLifeSettings())
    }
}
