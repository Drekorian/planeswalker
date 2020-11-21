package cz.drekorian.android.planeswalker.scryfall.api.model

import com.squareup.moshi.Json

/**
 * This data class represents a list of scryfall rulings.
 *
 * See [Scryfall List API](https://scryfall.com/docs/api/lists) for more information.
 * @author Marek Osvald
 * @see ScryfallRuling
 */
data class ScryfallRulingList(
    @Json(name = "has_more") private val hasMore: Boolean,
    override val data: List<ScryfallRuling>
) : ScryfallList<ScryfallRuling>
