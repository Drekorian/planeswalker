package cz.drekorian.android.planeswalker.scryfall.internal.retrofit

import androidx.lifecycle.LiveData
import cz.drekorian.android.planeswalker.scryfall.api.ApiResponse
import cz.drekorian.android.planeswalker.scryfall.api.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * This interface represents Scryfall's RESTful API.
 *
 * @author Marek Osvald
 */
interface ScryfallService {

    /**
     * Returns a [ScryfallSetList] of all MTG sets.
     *
     * @return a list of all MTG sets
     */
    @GET("/sets")
    fun getSets(): LiveData<ApiResponse<ScryfallSetList>>

    /**
     * Returns an [ScryfallSet] with given [id].
     *
     * @param id unique set ID
     * @return an MTG set with given [id]
     */
    @GET("/sets/{id}")
    fun getSetById(@Path("id") id: String): LiveData<ApiResponse<ScryfallSet>>

    /**
     * Returns an [ScryfallSet] with given [code].
     *
     * @param code a unique three to five-letter code
     * @return an MTG set with given [code]
     */
    @GET("/sets/{code}")
    fun getSetByCode(@Path("code") code: String): LiveData<ApiResponse<ScryfallSetList>>

    /**
     * Returns a [ScryfallSet] with given [tcgPlayerId].
     *
     * @param tcgPlayerId unique TCG Player ID for given set
     * @return an MTG set with given [tcgPlayerId]
     */
    @GET("/sets/{tcgPlayerId}")
    fun getSetByTcgPlayerId(@Path("tcgPlayerId") tcgPlayerId: String): LiveData<ApiResponse<ScryfallSetList>>

    /**
     * Returns [ScryfallCardList] of cards in a set.
     *
     * @param setQuery Scryfall search query
     * @return a list of cards in a set
     */
    @GET("/cards/search")
    fun getCardsInSet(@Query("q") setQuery: String): LiveData<ApiResponse<ScryfallCardList>>

    /**
     * Returns a [ScryfallCard] with given unique [id]
     *
     * @param id unique card ID
     * @return a card with given [id]
     */
    @GET("/cards/{id}")
    fun getCard(@Path("id") id: String): LiveData<ApiResponse<ScryfallCard>>

    /**
     * Returns [ScryfallRulingList] for a card in a set with given set [code] and collector
     * [number].
     *
     * @param code three to five-letter code of a given card's set
     * @param number card collector number
     * @return Scryfall ruling list for given card
     */
    @GET("/cards/{code}/{number}/rulings")
    fun getRulings(
        @Path("code") code: String,
        @Path("number") number: String
    ): LiveData<ApiResponse<ScryfallRulingList>>

    /**
     * Returns a random [ScryfallCard].
     *
     * @return a random [ScryfallCard]
     */
    @GET("/cards/random")
    fun getRandomCard(): LiveData<ApiResponse<ScryfallCard>>

    companion object {

        /**
         * Returns a setCode query for a set with given [code].
         *
         * @param a unique three to five-letter code for requested set
         */
        fun getSetCodeQuery(code: String): String = "set:$code"
    }
}
