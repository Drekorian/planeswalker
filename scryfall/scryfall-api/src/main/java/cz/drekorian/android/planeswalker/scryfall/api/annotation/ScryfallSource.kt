package cz.drekorian.android.planeswalker.scryfall.api.annotation

import com.squareup.moshi.JsonQualifier

/**
 * This annotation class determines a source a Scryfall ruling for a card.
 *
 * Possible sources are Wizards of the Coast (WOTC) and Scryfall team.
 *
 * @author Marek Osvald
 */
@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class ScryfallSource
