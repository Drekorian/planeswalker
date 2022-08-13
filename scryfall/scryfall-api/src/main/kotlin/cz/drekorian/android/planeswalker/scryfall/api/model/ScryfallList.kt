package cz.drekorian.android.planeswalker.scryfall.api.model

/**
 * This interface defines common API for Scryfall list objects.
 *
 * @property data list data
 * @see ScryfallSetList
 * @see ScryfallCardList
 * @see ScryfallRulingList
 * @author Marek Osvald
 */
interface ScryfallList<T> {

    /**
     * Stores list data.
     */
    val data: List<T>
}
