package cz.drekorian.android.planeswalker.scryfall.api

/**
 * This template class handles API responses and wraps them
 */
sealed class ApiResponse<T>

/**
 * This class represents an empty API response.
 */
class ApiEmptyResponse<T> : ApiResponse<T>()

/**
 * This data class represents a erroneous API response.
 *
 * @property errorCode API error code
 * @property errorMessage API error message
 */
data class ApiErrorResponse<T>(val errorCode: Int, val errorMessage: String) : ApiResponse<T>()

/**
 * This data class represents a successful API response.
 *
 * @property body API response body
 */
data class ApiSuccessResponse<T>(val body: T) : ApiResponse<T>()
