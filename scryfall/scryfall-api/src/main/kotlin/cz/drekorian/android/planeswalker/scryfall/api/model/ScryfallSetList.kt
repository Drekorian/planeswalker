package cz.drekorian.android.planeswalker.scryfall.api.model

import com.squareup.moshi.Json

/**
 * This data class represents a list of [ScryfallSet]s.
 *
 * See [Scryfall List API](https://scryfall.com/docs/api/lists) for more information.
 * @author Marek Osvald
 * @see ScryfallSet
 */
data class ScryfallSetList(
    @Json(name = "has_more") val hasMore: Boolean,
    override val data: List<ScryfallSet>
) : ScryfallList<ScryfallSet>
