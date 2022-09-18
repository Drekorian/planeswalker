package cz.drekorian.android.planeswalker.settings.life

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cz.drekorian.android.planeswalker.settings.SettingsManager

/**
 * This [ViewModel] handles the [SettingsLifeFragment] business logic.
 *
 * @see SettingsLifeFragment
 * @author Marek Osvald
 */
class SettingsLifeViewModel(
    private val settingsManager: SettingsManager
) : ViewModel() {

    private val _lifeCount: MutableLiveData<Int> = MutableLiveData(settingsManager.defaultLifeCount)

    /**
     * Stores current default life count.
     */
    val lifeCount: LiveData<Int>
        get() = _lifeCount

    /**
     * Sets and persists current life count.
     *
     * @param lifeCount life count to set.
     */
    fun onLifeCountClick(lifeCount: Int) {
        _lifeCount.value = lifeCount
        settingsManager.defaultLifeCount = lifeCount
    }
}
