package cz.drekorian.android.planeswalker.scryfall.api.model

import com.squareup.moshi.Json

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
data class ScryfallCard(
    @Json(name = "arena_id") val arenaId: Int?,
    @Json(name = "collector_number") val collectorNumber: String,
    val id: String,
    val lang: String,
    @Json(name = "mtgo_id") val mtgoId: Int?,
    @Json(name = "mtgo_foil_id") val mtgoFoilId: Int?,
    @Json(name = "multiverse_ids") val multiverseIds: List<Int>,
    @Json(name = "tcgplayer_id") val tcgPlayerId: Int?,
    @Json(name = "cardmarket_id") val cardMarketId: Int?,
    @Json(name = "oracle_id") val oracleId: String,
    @Json(name = "prints_search_uri") val printsSearchUri: String,
    @Json(name = "rulings_uri") val rulingsUri: String,
    @Json(name = "scryfall_uri") val scryfallUri: String,
    val uri: String,
    val name: String,
    @Json(name = "image_uris") val imageUris: ScryfallCardImagery?,
    @Json(name = "type_line") val typeLine: String,
    @Json(name = "oracle_text") val oracleText: String?,
    @Json(name = "flavor_text") val flavorText: String?,
    val power: String?,
    val toughness: String?,
    val artist: String,
    val set: String,
    @Json(name = "set_name") val setName: String,
    @Json(name = "card_faces") val cardFaces: List<ScryfallCardFace>?
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
        isDoubleFaced -> cardFaces!!.first().imageUris!!.png
        else -> imageUris!!.png
    }

    /**
     * Stores whether the card has two card faces, both on the front and the back of the card.
     */
    val isDoubleFaced: Boolean
        get() = cardFaces?.isNotEmpty() == true &&
                cardFaces.all { cardFace -> cardFace.imageUris != null }
}
