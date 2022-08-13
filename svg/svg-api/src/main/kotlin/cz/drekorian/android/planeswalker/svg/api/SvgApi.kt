package cz.drekorian.android.planeswalker.svg.api

import android.widget.ImageView

/**
 * This interface provides common API for SVG handling
 *
 * @author Marek Osvald
 */
interface SvgApi {

    /**
     * Attempts to load an SVG image from given [url] into given [ImageView].
     *
     * Upon failure, this function terminates quietly and logs an error.
     *
     * @param url requested SVG image URL
     * @param imageView an [ImageView] instance to load the SVG into
     * @param tintColor paint tint color
     */
    fun loadSvg(url: String, imageView: ImageView, tintColor: Int)
}
