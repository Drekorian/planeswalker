/**
 * This file contains ApiResponse-related mapping extensions.
 *
 * @author Marek Osvald
 */
package cz.drekorian.android.planeswalker.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import cz.drekorian.android.planeswalker.scryfall.api.ApiResponse
import cz.drekorian.android.planeswalker.scryfall.api.ApiSuccessResponse
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallList

/**
 * Maps [ApiResponse] [LiveData] into data [LiveData] instance.
 *
 * @receiver [LiveData] holding an [ApiResponse]
 * @return mapped [ApiResponse] data provided that the [ApiResponse] is successful, `null` otherwise
 */
internal fun <T : Any> LiveData<ApiResponse<T>>.mapApiResponse(
    onSuccess: (T) -> Unit = { }
): LiveData<T?> = map { apiResponse ->
    when (apiResponse) {
        is ApiSuccessResponse -> apiResponse.body.also { data -> onSuccess(data) }
        else -> null
    }
}

/**
 * Maps [ApiResponse] [LiveData] into data [LiveData] instance.
 *
 * @receiver [LiveData] holding an [ApiResponse] [List]
 * @return mapped [ApiResponse] data provided that the [ApiResponse] is successful, `null` otherwise
 *
 */
internal fun <X, T : ScryfallList<X>> LiveData<ApiResponse<T>>.mapApiResponseList(
    onSuccess: (List<X>?) -> Unit = {}
): LiveData<List<X>?> = map { apiResponse ->
    when (apiResponse) {
        is ApiSuccessResponse -> apiResponse.body.data.also { data -> onSuccess(data) }
        else -> null
    }
}

/**
 * Maps [ApiResponse] into its body when possible.
 *
 * @receiver valid [ApiResponse] instance
 * @return receiver body provided that the [ApiResponse] is successful, `null` otherwise
 */
internal fun <T> ApiResponse<T>.mapApiResponse(): T? = when (this) {
    is ApiSuccessResponse -> body
    else -> null
}
