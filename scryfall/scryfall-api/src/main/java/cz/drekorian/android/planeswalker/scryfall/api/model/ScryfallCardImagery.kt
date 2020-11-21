package cz.drekorian.android.planeswalker.scryfall.api.model

import com.squareup.moshi.Json

/**
 * This data class represents Scryfall imagery object for a [ScryfallCard].
 *
 * See [Scryfall API](https://scryfall.com/docs/api/images) for more information.
 *
 * @property png transparent PNG image with rounded corners
 * @property borderCrop cropped JPEG image with sharp corners
 * @property artCrop cropped art JPEG image
 * @property large a large full-card image
 * @property normal a medium-sized card image
 * @property small a small full-card image, designed for use as thumbnail or list icon
 * @see ScryfallCard
 * @author Marek Osvald
 */
data class ScryfallCardImagery(
    val png: String,
    @Json(name = "border_crop") val borderCrop: String,
    @Json(name = "art_crop") val artCrop: String,
    val large: String,
    val normal: String,
    val small: String
)
