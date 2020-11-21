package cz.drekorian.android.planeswalker.scryfall.internal.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import cz.drekorian.android.planeswalker.scryfall.api.annotation.ScryfallDate
import org.threeten.bp.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Custom type adapter that converts Scryfall date in the ISO-8601 format into a [LocalDate]
 * instance.
 *
 * @see cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallSet
 */
@Singleton
internal class ScryfallDateAdapter @Inject constructor() {

    @ToJson
    fun toJson(@ScryfallDate date: LocalDate) = date.toString()

    @FromJson
    @ScryfallDate
    fun fromJson(date: String): LocalDate = LocalDate.parse(date)
}
