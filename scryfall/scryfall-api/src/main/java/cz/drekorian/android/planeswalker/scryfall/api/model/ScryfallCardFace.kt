package cz.drekorian.android.planeswalker.scryfall.api.model

import com.squareup.moshi.Json

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
data class ScryfallCardFace(
    val name: String,
    @Json(name = "image_uris") val imageUris: ScryfallCardImagery?,
    @Json(name = "oracle_text") val oracleText: String
)
