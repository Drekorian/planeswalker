package cz.drekorian.android.planeswalker.scryfall.internal.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import cz.drekorian.android.planeswalker.scryfall.api.annotation.ScryfallSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Custom type adapter that converts Scryfall ruling source from and into a human-readable format.
 *
 * @see cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallRuling
 */
@Singleton
internal class ScryfallSourceAdapter @Inject constructor() {

    @ToJson
    fun toJson(@ScryfallSource source: String): String = when (source) {
        "wotc" -> "Wizards of the Coast"
        else -> " Scryfall"
    }

    @FromJson
    @ScryfallSource
    fun fromJson(source: String): String = when (source) {
        "wotc" -> "Wizards of the Coast"
        else -> " Scryfall"
    }
}
