/**
 * This file contains universally used binding adapters.
 *
 * @author Marek Osvald
 */
package cz.drekorian.android.planeswalker

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

/**
 * Sets "android:isVisible" property for given [view].
 *
 * @param view [View] instance to bind the property onto
 * @param value true in order to set visibility to [View.VISIBLE], false for [View.GONE]
 */
@BindingAdapter("android:isVisible")
fun setVisibility(view: View, value: Boolean) {
    view.isVisible = value
}
