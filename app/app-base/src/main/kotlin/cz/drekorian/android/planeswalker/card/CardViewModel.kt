package cz.drekorian.android.planeswalker.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import cz.drekorian.android.planeswalker.databinding.ItemRulingBinding
import cz.drekorian.android.planeswalker.scryfall.api.ApiResponse
import cz.drekorian.android.planeswalker.scryfall.api.ScryfallApi
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCard
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallRuling
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallRulingList
import cz.drekorian.android.planeswalker.util.mapApiResponse

/**
 * This [ViewModel] handles logic for card detail screen.
 *
 * @author Marek Osvald
 * @see CardFragment
 */
class CardViewModel(
    private val scryfallApi: ScryfallApi,
) : ViewModel() {

    private lateinit var cardApiResponse: LiveData<ApiResponse<ScryfallCard>>

    private lateinit var rulingsApiResponse: LiveData<ApiResponse<ScryfallRulingList>>

    val card: LiveData<ScryfallCard> by lazy(LazyThreadSafetyMode.NONE) {
        cardApiResponse.mapApiResponse { card ->
            // load rulings in response
            rulingsApiResponse = scryfallApi.getRulings(card.set, card.collectorNumber)
            _rulings.addSource(rulingsApiResponse) { response: ApiResponse<ScryfallRulingList> ->
                _rulings.value = response.mapApiResponse()?.data
            }
        }
    }

    private val _rulings: MediatorLiveData<List<ScryfallRuling>> = MediatorLiveData()

    /**
     * Stores card rulings for the fechted card.
     */
    val rulings: LiveData<List<ScryfallRuling>>
        get() = _rulings

    /**
     * Requests card for given [id].
     *
     * @param id unique Scryfall card ID
     */
    fun fetchCard(id: String) {
        cardApiResponse = scryfallApi.getCard(id)
    }
}

@BindingAdapter("rulings")
fun setRulings(viewGroup: ViewGroup, rulings: List<ScryfallRuling>?) {
    if (rulings == null) {
        return
    }

    val layoutInflater = LayoutInflater.from(viewGroup.context)

    for (ruling in rulings) {
        ItemRulingBinding.inflate(layoutInflater, viewGroup, false).also { binding ->
            binding.ruling = ruling
            viewGroup.addView(binding.root)
        }
    }
}
