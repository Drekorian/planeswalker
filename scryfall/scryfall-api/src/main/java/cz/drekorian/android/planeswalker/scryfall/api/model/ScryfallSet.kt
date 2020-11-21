package cz.drekorian.android.planeswalker.scryfall.api.model

import com.squareup.moshi.Json
import cz.drekorian.android.planeswalker.scryfall.api.annotation.ScryfallDate
import org.threeten.bp.LocalDate

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
 * @property isFoilOnly  true, provided that this set only contains foil cards, false otherwise
 * @property iconSvgUri a URI for this set's icon
 */
data class ScryfallSet(
    val id: String,
    val code: String,
    val name: String,
    val uri: String,
    @Json(name = "scryfall_uri") val scryfallUri: String,
    @Json(name = "search_uri") val searchUri: String,
    @ScryfallDate @Json(name = "released_at") val releasedAt: LocalDate,
    @Json(name = "set_type") val setType: String,
    @Json(name = "card_count") val cardCount: Int,
    @Json(name = "digital") val isDigital: Boolean,
    @Suppress("SpellCheckingInspection")
    @Json(name = "nonfoil_only") val isNonFoilOnly: Boolean,
    @Json(name = "foil_only") val isFoilOnly: Boolean,
    @Json(name = "icon_svg_uri") val iconSvgUri: String
)
