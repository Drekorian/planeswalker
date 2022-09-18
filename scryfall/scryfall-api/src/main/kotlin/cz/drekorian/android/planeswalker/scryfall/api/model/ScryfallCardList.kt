package cz.drekorian.android.planeswalker.scryfall.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * This class represents a Scryfall card list.
 *
 * @property hasMore true, provided that pagination calls provide more data, false otherwise
 * @property data a list of [ScryfallCard]s
 * @see ScryfallCard
 * @author Marek Osvald
 */
@Serializable
data class ScryfallCardList(
    @JsonNames("has_more") val hasMore: Boolean,
    @JsonNames("data") override val data: List<ScryfallCard>
) : ScryfallList<ScryfallCard>
