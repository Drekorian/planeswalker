package cz.drekorian.android.planeswalker.scryfall.api.model

import cz.drekorian.android.planeswalker.scryfall.internal.adapter.ScryfallSourceSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

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
@Serializable
data class ScryfallRuling(
    @Serializable(with = ScryfallSourceSerializer::class)
    @JsonNames("source") val source: String,
    @JsonNames("published_at") val publishedAt: LocalDate,
    @JsonNames("comment") val comment: String
)
