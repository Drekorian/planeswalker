package cz.drekorian.android.planeswalker.scryfall.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * This data class represents a single card-face of a multi-faced card.
 *
 * See documentation on [Scryfall API](https://scryfall.com/docs/api/cards).
 *
 * @property oracleText Oracle text for given card face, if any
 * @property imageUris an object of available imagery for given card face
 * @see ScryfallCard
 * @see ScryfallCardImagery
 * @author Marek Osvald
 */
@Serializable
data class ScryfallCardFace(
    val name: String,
    @JsonNames("image_uris") val imageUris: ScryfallCardImagery?,
    @JsonNames("oracle_text") val oracleText: String
)
