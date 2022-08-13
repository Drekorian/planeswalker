package cz.drekorian.android.planeswalker.scryfall.internal.retrofit

import androidx.lifecycle.LiveData
import cz.drekorian.android.planeswalker.scryfall.api.ApiEmptyResponse
import cz.drekorian.android.planeswalker.scryfall.api.ApiErrorResponse
import cz.drekorian.android.planeswalker.scryfall.api.ApiResponse
import cz.drekorian.android.planeswalker.scryfall.api.ApiSuccessResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

/**
 * This adapter converts Retrofit [Call]s into a [LiveData] [ApiResponse]s.
 *
 * @author Marek Osvald
 */
class LiveDataCallAdapter<R>(private val responseType: Type): CallAdapter<R, LiveData<ApiResponse<R>>> {

    override fun responseType(): Type = responseType

    override fun adapt(call: Call<R>): LiveData<ApiResponse<R>> {
        return object : LiveData<ApiResponse<R>>() {
            override fun onActive() {
                super.onActive()
                if (!call.isExecuted) {
                    enqueue()
                }
            }

            override fun onInactive() {
                super.onInactive()
                if (call.isExecuted) {
                    call.cancel()
                }
            }

            private fun enqueue() {
                call.enqueue(object : Callback<R> {
                    override fun onFailure(call: Call<R>, t: Throwable) {
                        postValue(create(UNKNOWN_CODE, t))
                    }

                    override fun onResponse(call: Call<R>, response: Response<R>) {
                        postValue(create(response))
                    }
                })
            }
        }
    }

    private fun <T> create(response: Response<T>): ApiResponse<T> {
        return if (response.isSuccessful) {
            val body = response.body()
            if (body == null || response.code() == 204) {
                ApiEmptyResponse()
            } else {
                ApiSuccessResponse(body)
            }
        } else {
            ApiErrorResponse(
                response.code(),
                response.errorBody()?.string() ?: response.message()
            )
        }
    }

    private fun <T> create(errorCode: Int, error: Throwable): ApiErrorResponse<T> {
        return ApiErrorResponse(errorCode, error.message ?: "Unknown Error")
    }

    companion object {

        const val UNKNOWN_CODE = -1
    }
}
