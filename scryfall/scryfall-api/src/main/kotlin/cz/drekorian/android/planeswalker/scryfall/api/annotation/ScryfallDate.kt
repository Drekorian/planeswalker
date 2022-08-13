package cz.drekorian.android.planeswalker.scryfall.api.annotation

import com.squareup.moshi.JsonQualifier

/**
 * This annotation class denotes a date in the [ISO-8601](https://en.wikipedia.org/wiki/ISO_8601)
 * format.
 *
 * @author Marek Osvald
 */
@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class ScryfallDate
