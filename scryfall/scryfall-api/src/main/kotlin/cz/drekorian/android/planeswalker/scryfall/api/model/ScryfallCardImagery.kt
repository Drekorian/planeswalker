package cz.drekorian.android.planeswalker.scryfall.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

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
@Serializable
data class ScryfallCardImagery(
    val png: String,
    @JsonNames("border_crop") val borderCrop: String,
    @JsonNames("art_crop") val artCrop: String,
    @JsonNames("large") val large: String,
    @JsonNames("normal")val normal: String,
    @JsonNames("small") val small: String
)
