package cz.drekorian.android.planeswalker.lifecounter

import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.viewModels
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.activity.BaseActivity

/**
 * This activity hosts the [LifeCounterFragment].
 *
 * @see LifeCounterFragment
 * @see R.navigation.navigation_life_counter
 * @author Marek Osvald
 */
class LifeCounterActivity : BaseActivity() {

    val viewModel: LifeCounterViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_counter)
    }

    /**
     * Handles incrementing and decrementing of life using the volume keys.
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean = when (keyCode) {
        KeyEvent.KEYCODE_VOLUME_UP -> {
            viewModel.incrementLife()
            true
        }

        KeyEvent.KEYCODE_VOLUME_DOWN -> {
            viewModel.decrementLife()
            true
        }

        else -> super.onKeyDown(keyCode, event)
    }
}
