package cz.drekorian.android.planeswalker.scryfall.api

import androidx.lifecycle.LiveData
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCard
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCardList
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallRulingList
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallSetList

/**
 * This interface defines the contract for Scryfall API implementations.
 *
 * @author Marek Osvald
 */
interface ScryfallApi {

    /**
     * Returns [ScryfallSetList] of all MTG sets as [ApiResponse] [LiveData].
     */
    fun getSets(): LiveData<ApiResponse<ScryfallSetList>>

    /**
     * Returns [ScryfallCardList] for a set with given [code] as [ApiResponse] [LiveData].
     *
     * @param code unique MTG set code
     */
    fun getCardsForSet(code: String): LiveData<ApiResponse<ScryfallCardList>>

    /**
     * Returns [ScryfallCard] instance for given [id] as [ApiResponse] [LiveData].
     *
     * @param id unique Scryfall card ID
     */
    fun getCard(id: String): LiveData<ApiResponse<ScryfallCard>>

    /**
     * Returns [ScryfallRulingList] for a card with given set [code] and collector [number] as
     * [ApiResponse] [LiveData].
     *
     * @param code unique MTG set code
     * @param number card's collector number
     */
    fun getRulings(code: String, number: String): LiveData<ApiResponse<ScryfallRulingList>>

    /**
     * Returns a random [ScryfallCard] as [ApiResponse] [LiveData].
     */
    fun getRandomCard(): LiveData<ApiResponse<ScryfallCard>>
}
