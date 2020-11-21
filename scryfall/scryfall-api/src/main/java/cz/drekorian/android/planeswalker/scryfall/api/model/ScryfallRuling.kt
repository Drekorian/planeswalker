package cz.drekorian.android.planeswalker.scryfall.api.model

import com.squareup.moshi.Json
import cz.drekorian.android.planeswalker.scryfall.api.annotation.ScryfallDate
import cz.drekorian.android.planeswalker.scryfall.api.annotation.ScryfallSource
import org.threeten.bp.LocalDate

/**
 * This data class represents a single [ScryfallCard] ruling.
 *
 * See [Scryfall API](https://scryfall.com/docs/api/rulings) for more information.
 *
 * @property source a computer-readable string indicating which company produced this ruling, either
 * wotc or scryfall
 * @property publishedAt the date when the ruling or note was published
 * @property comment the text of the ruling
 * @see ScryfallCard
 * @author Marek Osvald
 */
data class ScryfallRuling(
    @ScryfallSource val source: String,
    @Json(name = "published_at") @ScryfallDate val publishedAt: LocalDate,
    val comment: String
)
