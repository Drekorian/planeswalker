package cz.drekorian.android.planeswalker.scryfall.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames


/**
 * This data class represents a list of scryfall rulings.
 *
 * See [Scryfall List API](https://scryfall.com/docs/api/lists) for more information.
 * @author Marek Osvald
 * @see ScryfallRuling
 */
@Serializable
data class ScryfallRulingList(
    @JsonNames("has_more") private val hasMore: Boolean,
    @JsonNames("data") override val data: List<ScryfallRuling>
) : ScryfallList<ScryfallRuling>
