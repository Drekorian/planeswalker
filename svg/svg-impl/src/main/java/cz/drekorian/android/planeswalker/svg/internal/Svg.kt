package cz.drekorian.android.planeswalker.svg.internal

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import android.widget.ImageView
import com.pixplicity.sharp.OnSvgElementListener
import com.pixplicity.sharp.Sharp
import cz.drekorian.android.planeswalker.svg.api.SvgApi
import dagger.Lazy
import okhttp3.*
import java.io.IOException
import javax.inject.Inject

/**
 * This class serves as the default implementation of [SvgApi].
 *
 * @author Marek Osvald
 */
internal class Svg @Inject constructor(private val okHttpClient: Lazy<OkHttpClient>) : SvgApi {

    override fun loadSvg(url: String, imageView: ImageView, tintColor: Int) {
        imageView.setImageDrawable(null)
        val request = Request.Builder()
            .url(url)
            .build()

        okHttpClient.get().newCall(request).enqueue(SvgCallback(imageView, tintColor))
    }

    private class SvgCallback(
        private val imageView: ImageView,
        private val tintColor: Int
    ) : Callback {
        override fun onFailure(call: Call, e: IOException) {
            Log.e("SvgImpl", "SVG call failed: ${e.localizedMessage}\n${e.stackTrace}")
        }

        override fun onResponse(call: Call, response: Response) {
            if (!response.isSuccessful) {
                return
            }
            response.body()?.byteStream()?.use { stream ->
                Sharp.loadInputStream(stream)
                    .setOnElementListener(object : OnSvgElementListener {
                        override fun onSvgStart(canvas: Canvas, bounds: RectF?) { /* no- op */ }

                        override fun onSvgEnd(canvas: Canvas, bounds: RectF?) { /* no-op */ }

                        override fun <T : Any?> onSvgElement(
                            id: String?,
                            element: T,
                            elementBounds: RectF?,
                            canvas: Canvas,
                            canvasBounds: RectF?,
                            paint: Paint?
                        ): T {
                            paint?.color = imageView.context.getColor(tintColor)
                            return element
                        }

                        override fun <T : Any?> onSvgElementDrawn(
                            id: String?,
                            elemnt: T,
                            canvas: Canvas,
                            pant: Paint?) { /* no-op */}
                    })
                    .into(imageView)
            }
        }
    }
}
