package cz.drekorian.android.planeswalker.scryfall

import android.os.Bundle
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.activity.BaseActivity

/**
 * This activity displays the hosts the Scryfall UI navigation component fragments.
 *
 * @see cz.drekorian.android.planeswalker.card.CardFragment
 * @see cz.drekorian.android.planeswalker.set.SetFragment
 * @see cz.drekorian.android.planeswalker.set.list.SetListFragment
 * @see cz.drekorian.android.planeswalker.R.navigation.navigation_scryfall
 * @author Marek Osvald
 */
class ScryfallActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scryfall)
    }
}
