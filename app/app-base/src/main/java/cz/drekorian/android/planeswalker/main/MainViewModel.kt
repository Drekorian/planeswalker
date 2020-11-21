package cz.drekorian.android.planeswalker.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import cz.drekorian.android.planeswalker.scryfall.api.ApiResponse
import cz.drekorian.android.planeswalker.scryfall.api.ScryfallApi
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCard
import cz.drekorian.android.planeswalker.util.mapApiResponse
import javax.inject.Inject

/**
 * This [ViewModel] handles business logic for [MainFragment].
 *
 * @see MainFragment
 * @author Marek Osvald
 */
class MainViewModel @Inject constructor(private val scryfallApi: ScryfallApi) : ViewModel() {

    private val randomCardApiResponse: LiveData<ApiResponse<ScryfallCard>> = scryfallApi.getRandomCard()

    /**
     * Stores a retrieved random card.
     */
    val randomCard: LiveData<ScryfallCard>
        get() = randomCardApiResponse.mapApiResponse()

    /**
     * Handles tapping the Scryfall action.
     *
     * @param view clicked [View] instance
     */
    fun onScryfallClick(view: View) {
        view.findNavController().navigate(MainFragmentDirections.openScryfall())
    }

    /**
     * Handles tapping the Life Counter action.
     *
     * @param view clicked [View] instance
     */
    fun onLifeCounterClick(view: View) {
        view.findNavController().navigate(MainFragmentDirections.openLifeCounter())
    }

    /**
     * Handles tapping the Settings action.
     *
     * @param view clicked [View] instance
     */
    fun onSettingsClick(view: View) {
        view.findNavController().navigate(MainFragmentDirections.openSettings())
    }
}
