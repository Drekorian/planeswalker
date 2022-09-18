package cz.drekorian.android.planeswalker.scryfall.internal.retrofit

import androidx.lifecycle.LiveData
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * This factory provides [LiveDataCallAdapter]s.
 *
 * @author Marek Osvald
 */
internal class LiveDataCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        // handle Call to LiveData conversions only
        if (getRawType(returnType) != LiveData::class.java) {
            return null
        }

        val observableType =
            getParameterUpperBound(0, returnType as ParameterizedType) as ParameterizedType

        return LiveDataCallAdapter<Any>(
            getParameterUpperBound(
                0,
                observableType
            )
        )
    }
}
