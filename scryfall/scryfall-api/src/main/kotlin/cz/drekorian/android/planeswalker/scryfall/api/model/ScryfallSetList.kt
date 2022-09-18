package cz.drekorian.android.planeswalker.scryfall.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * This data class represents a list of [ScryfallSet]s.
 *
 * See [Scryfall List API](https://scryfall.com/docs/api/lists) for more information.
 * @author Marek Osvald
 * @see ScryfallSet
 */
@Serializable
data class ScryfallSetList(
    @JsonNames("has_more") val hasMore: Boolean,
    @JsonNames("data") override val data: List<ScryfallSet>
) : ScryfallList<ScryfallSet>
