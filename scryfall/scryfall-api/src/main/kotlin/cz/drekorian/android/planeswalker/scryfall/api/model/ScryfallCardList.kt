package cz.drekorian.android.planeswalker.scryfall.api.model

import com.squareup.moshi.Json

/**
 * This class represents a Scryfall card list.
 *
 * @property hasMore true, provided that pagination calls provide more data, false otherwise
 * @property data a list of [ScryfallCard]s
 * @see ScryfallCard
 * @author Marek Osvald
 */
data class ScryfallCardList(
    @Json(name = "has_more") val hasMore: Boolean,
    override val data: List<ScryfallCard>
) : ScryfallList<ScryfallCard>
