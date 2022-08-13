package cz.drekorian.android.planeswalker.scryfall.internal.retrofit

import androidx.lifecycle.LiveData
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This factory provides [LiveDataCallAdapter]s.
 *
 * @author Marek Osvald
 */
@Singleton
class LiveDataCallAdapterFactory @Inject constructor() : CallAdapter.Factory() {
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
