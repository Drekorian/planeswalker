package cz.drekorian.android.planeswalker

import android.graphics.Bitmap
import android.graphics.Matrix
import coil.size.Size
import coil.transform.Transformation

/**
 * This [Transformation] flips the source [Bitmap] horizontally.
 *
 * @author Marek Osvald
 */
class FlipTransformation : Transformation {

    override val cacheKey: String
        get() = KEY

    override suspend fun transform(input: Bitmap, size: Size): Bitmap {
        val matrix: Matrix = Matrix().apply { preScale(AXIS_REVERSE, AXIS_ID) }
        val output = Bitmap.createBitmap(input, 0, 0, input.width, input.height, matrix, true)
        input.recycle()
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
