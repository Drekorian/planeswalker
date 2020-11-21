package cz.drekorian.android.planeswalker.scryfall

import androidx.lifecycle.LiveData
import cz.drekorian.android.planeswalker.scryfall.api.ApiResponse
import cz.drekorian.android.planeswalker.scryfall.api.ScryfallApi
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCard
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCardList
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallRulingList
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallSetList
import cz.drekorian.android.planeswalker.scryfall.internal.di.ScryfallComponentHolder
import cz.drekorian.android.planeswalker.scryfall.internal.retrofit.ScryfallService

/**
 * This object serves as the default implementation of [ScryfallApi].
 *
 * @author Marek Osvald
 */
object Scryfall : ScryfallApi {

    private val scryfallService by lazy(LazyThreadSafetyMode.NONE) {
        ScryfallComponentHolder.component.scryfallService()
    }

    override fun getSets(): LiveData<ApiResponse<ScryfallSetList>> =
        scryfallService.getSets()

    override fun getCardsForSet(code: String): LiveData<ApiResponse<ScryfallCardList>> =
        scryfallService.getCardsInSet(ScryfallService.getSetCodeQuery(code))

    override fun getCard(id: String): LiveData<ApiResponse<ScryfallCard>> =
        scryfallService.getCard(id)

    override fun getRulings(
        code: String,
        number: String
    ): LiveData<ApiResponse<ScryfallRulingList>> = scryfallService.getRulings(code, number)

    override fun getRandomCard(): LiveData<ApiResponse<ScryfallCard>> =
        scryfallService.getRandomCard()
}
