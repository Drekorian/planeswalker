package cz.drekorian.android.planeswalker.set

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import cz.drekorian.android.planeswalker.scryfall.api.ApiResponse
import cz.drekorian.android.planeswalker.scryfall.api.ScryfallApi
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCard
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCardList
import cz.drekorian.android.planeswalker.util.mapApiResponseList
import javax.inject.Inject

/**
 * This [ViewModel] handles the business logic of [SetViewModel].
 *
 * @author Marek Osvald
 */
class SetViewModel @Inject constructor(private val scryfallApi: ScryfallApi) : ViewModel() {

    private lateinit var cardsApiResponse: LiveData<ApiResponse<ScryfallCardList>>

    /**
     * Stores [ScryfallCard]s in given set.
     */
    val cards: LiveData<List<ScryfallCard>> by lazy(LazyThreadSafetyMode.NONE) {
        cardsApiResponse.mapApiResponseList()
    }

    /**
     * Retrieves the list of cards for given set [code].
     *
     * @param code unique three to five-letter code of a given set
     */
    fun fetchCards(code: String) {
        cardsApiResponse = scryfallApi.getCardsForSet(code)
    }
}

/**
 * Sets an adapter populated with [cards] onto a given [recyclerView].
 *
 * @param recyclerView [RecyclerView] instance to display cards
 * @param cards a list of cards to display
 */
@BindingAdapter("adapter")
fun setAdapter(recyclerView: RecyclerView, cards: List<ScryfallCard>?) {
    if (cards == null) {
        return
    }

    recyclerView.adapter = SetAdapter(recyclerView.context, cards)
}
