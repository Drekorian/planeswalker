package cz.drekorian.android.planeswalker.lifecounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cz.drekorian.android.planeswalker.settings.SettingsManager

/**
 * This [ViewModel] handles the business logic for [LifeCounterFragment].
 *
 * @see LifeCounterActivity
 * @see LifeCounterFragment
 * @author Marek Osvald
 */
class LifeCounterViewModel(
    private val settingsManager: SettingsManager,
) : ViewModel() {

    private val _life: MutableLiveData<Int> = MutableLiveData(settingsManager.defaultLifeCount)

    /**
     * Stores current player's life total.
     */
    val life: LiveData<Int>
        get() = _life

    /**
     * Increases current life count by one.
     */
    fun incrementLife() {
        _life.value = _life.value!! + 1
    }

    /**
     * Decreases current life count by one.
     */
    fun decrementLife() {
        _life.value = _life.value!! - 1
    }

    /**
     * Resets current life to a set defautl.
     */
    fun onNewGameClick() {
        _life.value = settingsManager.defaultLifeCount
    }
}
