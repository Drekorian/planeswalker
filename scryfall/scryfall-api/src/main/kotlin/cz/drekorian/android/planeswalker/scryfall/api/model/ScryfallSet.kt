package cz.drekorian.android.planeswalker.scryfall.api.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * This data class represents a single MTG set.
 *
 * See [Scryfall API](https://scryfall.com/docs/api/sets) for more information.
 *
 * @property id unique set ID
 * @property code a unique three to five-letter code for this set
 * @property name full set name
 * @property uri Scryfall URI for this set
 * @property scryfallUri a Scryfall permanent link for this set
 * @property searchUri a Scryfall API URI for card pagination of the cards over the cards in this
 * set
 * @property releasedAt release date in the ISO-8601 format
 * @property setType a computer-readable classification of this set
 * @property cardCount the number of cards in this set
 * @property isDigital true, provided that this set has only been released in a video game, false
 * otherwise
 * @property isNonFoilOnly true, provided that this set only contains non-foil cards, false
 * otherwise
 * @property isFoilOnly true, provided that this set only contains foil cards, false otherwise
 * @property iconSvgUri a URI for this set's icon
 */
@Serializable
data class ScryfallSet(
    @JsonNames("id")val id: String,
    @JsonNames("code") val code: String,
    @JsonNames("name") val name: String,
    @JsonNames("uri") val uri: String,
    @JsonNames("scryfall_uri") val scryfallUri: String,
    @JsonNames("search_uri") val searchUri: String,
    @JsonNames("released_at") val releasedAt: LocalDate,
    @JsonNames("set_type") val setType: String,
    @JsonNames("card_count") val cardCount: Int,
    @JsonNames("digital") val isDigital: Boolean,
    @Suppress("SpellCheckingInspection")
    @JsonNames("nonfoil_only") val isNonFoilOnly: Boolean,
    @JsonNames("foil_only") val isFoilOnly: Boolean,
    @JsonNames("icon_svg_uri") val iconSvgUri: String
)
