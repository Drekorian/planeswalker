package cz.drekorian.android.planeswalker.card

import android.animation.ValueAnimator
import android.widget.ImageView
import androidx.annotation.MainThread
import com.squareup.picasso.Picasso
import cz.drekorian.android.planeswalker.FlipTransformation
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCard
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * This helper class handles the flip animation in the card details fragment.
 *
 * @author Marek Osvald
 */
class CardFlipHelper @Inject constructor(private val picasso: Picasso) {

    private lateinit var card: ScryfallCard

    private lateinit var imageView: WeakReference<ImageView>

    fun initialize(card: ScryfallCard, imageView: ImageView) {
        this.card = card
        this.imageView = WeakReference(imageView)
    }

    /**
     * Flips a displayed card.
     */
    @MainThread
    fun flip() {
        val imageView = imageView.get() ?: return
        imageView.animate()
            .rotationY(
                when (imageView.rotationY) {
                    FRONT_SIDE_ROTATION -> BACK_SIDE_ROTATION
                    else -> FRONT_SIDE_ROTATION
                }
            )
            .setDuration(400L)
            .setUpdateListener(
                when (imageView.rotationY) {
                    FRONT_SIDE_ROTATION -> ForwardAnimationUpdateListener(
                        card,
                        picasso,
                        this.imageView
                    )
                    else -> ReverseAnimatorUpdateListener(card, picasso, this.imageView)
                }
            )
            .start()
    }

    private class ForwardAnimationUpdateListener(
        private val card: ScryfallCard,
        private val picasso: Picasso,
        private val imageView: WeakReference<ImageView>
    ) : ValueAnimator.AnimatorUpdateListener {

        private var isFlipped: Boolean = false

        override fun onAnimationUpdate(animation: ValueAnimator) {
            if (!isFlipped && (animation.animatedValue as Float) >= 0.4f) {
                isFlipped = true
                picasso
                    .run {
                        when {
                            card.isDoubleFaced -> load(card.cardFaces!![1].imageUris!!.png)
                            else -> load(R.drawable.card_back)
                        }
                    }
                    .fit()
                    .centerCrop()
                    .transform(FlipTransformation())
                    .into(imageView.get() ?: return)
            }
        }
    }

    private class ReverseAnimatorUpdateListener(
        private val card: ScryfallCard,
        private val picasso: Picasso,
        private val imageView: WeakReference<ImageView>
    ) : ValueAnimator.AnimatorUpdateListener {

        private var isFlipped: Boolean = false

        override fun onAnimationUpdate(animation: ValueAnimator) {
            if (!isFlipped && (animation.animatedValue as Float) >= 0.4f) {
                isFlipped = true
                picasso
                    .load(card.primaryPng)
                    .fit()
                    .centerCrop()
                    .into(imageView.get() ?: return)
            }
        }
    }

    companion object {

        /**
         * [ImageView] rotation for of a front card face.
         */
        const val FRONT_SIDE_ROTATION = 0f // degrees

        /**
         * [ImageView] rotation for of a back card face.
         */
        const val BACK_SIDE_ROTATION = 180f // degrees
    }
}
