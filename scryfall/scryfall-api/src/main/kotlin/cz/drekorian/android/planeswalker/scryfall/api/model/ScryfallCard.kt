package cz.drekorian.android.planeswalker.scryfall.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames

/**
 * This data class represents a single MTG card.
 *
 * @property arenaId MTG Arena unique ID, optional as not all cards are available on Arena
 * @property collectorNumber collector number unique for given set
 * @property id unique card ID
 * @property lang language of the card
 * @property mtgoId MTG Online unique ID, optional as not all cards are available on MTG Online
 * @property mtgoFoilId MTG Online unique ID for a foil version of this card, optional
 * @property multiverseIds IDs used by Gatherer, optional as Scryfall contains additional content
 * @property tcgPlayerId unique card ID used by TCG Player
 * @property cardMarketId unique card ID used by Card Market
 * @property oracleId UUID consistent across reprinted card editions, and unique among different
 * cards with the same name
 * @property printsSearchUri a link for Scryfall search for all available prints of given card
 * @property rulingsUri link for Scryfall search of rulings for given card
 * @property scryfallUri  a permanent link to this card’s page on Scryfall's website
 * @property uri a link to this card object on Scryfall's API
 * @property imageUris an object of available imagery for given card
 * @property typeLine type line of this card
 * @property oracleText the Oracle text for this card, if any
 * @property power this card's power, if any
 * @property toughness this card's toughness, if any
 * @property artist this card's illustrator
 * @property set this cards's set code
 * @property setName this card's full set name
 * @property cardFaces property containing card faces for multi-faced cards
 *
 * See documentation on [Scryfall API](https://scryfall.com/docs/api/cards).
 *
 * @see ScryfallCardFace
 * @see ScryfallCardImagery
 * @see ScryfallRuling
 * @author Marek Osvald
 */
@Serializable
data class ScryfallCard(
    @JsonNames("arena_id") val arenaId: Int? = null,
    @JsonNames("collector_number") val collectorNumber: String,
    @JsonNames("id") val id: String,
    @JsonNames("lang") val lang: String,
    @JsonNames("mtgo_id") val mtgoId: Int? = null,
    @JsonNames("mtgo_foil_id") val mtgoFoilId: Int? = null,
    @JsonNames("multiverse_ids") val multiverseIds: List<Int>,
    @JsonNames("tcgplayer_id") val tcgPlayerId: Int? = null,
    @JsonNames("cardmarket_id") val cardMarketId: Int? = null,
    @JsonNames("oracle_id") val oracleId: String,
    @JsonNames("prints_search_uri") val printsSearchUri: String,
    @JsonNames("rulings_uri") val rulingsUri: String,
    @JsonNames("scryfall_uri") val scryfallUri: String,
    @JsonNames("uri") val uri: String,
    @JsonNames("name") val name: String,
    @JsonNames("image_uris") val imageUris: ScryfallCardImagery?,
    @JsonNames("type_line") val typeLine: String,
    @JsonNames("oracle_text") val oracleText: String?,
    @JsonNames("flavor_text") val flavorText: String? = null,
    @JsonNames("power") val power: String? = null,
    @JsonNames("toughness") val toughness: String? = null,
    @JsonNames("artist") val artist: String,
    @JsonNames("set") val set: String,
    @JsonNames("set_name") val setName: String,
    @JsonNames("card_faces") val cardFaces: List<ScryfallCardFace>? = null
) {
    /**
     * Stores primary cropped art image.
     *
     * For a single-faced card it's the same as [imageUris] cropped art image.
     * For a double-faced card it's the cropped art image on the front of the card.
     */
    @Transient
    val primaryArtCrop: String = when {
        isDoubleFaced -> cardFaces!!.first().imageUris!!.artCrop
        else -> imageUris!!.artCrop
    }

    /**
     * Stores primary card PNG image.
     *
     * For a single-faced card it's the same as [imageUris] PNG image.
     * For a double-faced card it's the face on the front of the card.
     */
    @Transient
    val primaryPng: String = when {
        isDoubleFaced -> cardFaces?.first()?.imageUris?.png ?: ""
        else -> imageUris?.png ?: ""
    }

    /**
     * Stores whether the card has two card faces, both on the front and the back of the card.
     */
    val isDoubleFaced: Boolean
        get() = cardFaces?.isNotEmpty() == true &&
                cardFaces.all { cardFace -> cardFace.imageUris != null }
}
