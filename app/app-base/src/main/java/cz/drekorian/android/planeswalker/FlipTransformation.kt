package cz.drekorian.android.planeswalker

import android.graphics.Bitmap
import android.graphics.Matrix
import com.squareup.picasso.Transformation

/**
 * This [Transformation] flips the source [Bitmap] horizontally.
 *
 * @author Marek Osvald
 */
class FlipTransformation : Transformation {

    override fun key() = KEY

    override fun transform(source: Bitmap): Bitmap {
        val matrix: Matrix = Matrix().apply { preScale(AXIS_REVERSE, AXIS_ID) }
        val output = Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
        source.recycle()
        return output
    }

    companion object {

        /**
         * Identity transformation of a Matrix axis.
         */
        private const val AXIS_ID = 1.0f

        /**
         * Reverse transformation of a Matrix axis.
         */
        private const val AXIS_REVERSE = -1.0f

        /**
         * Unique transformation key.
         */
        const val KEY = "FlipTransformation"
    }
}
