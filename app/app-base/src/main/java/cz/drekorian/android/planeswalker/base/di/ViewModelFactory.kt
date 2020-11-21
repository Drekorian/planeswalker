package cz.drekorian.android.planeswalker.base.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * This factory provides [ViewModel]s.
 *
 * @author Marek Osvald
 */
@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = viewModelsMap[modelClass]
            ?: viewModelsMap.asIterable()
                .firstOrNull { (key, _) -> modelClass.isAssignableFrom(key) }?.value
            ?: throw IllegalArgumentException("Unknown model class: '$modelClass'")

        return try {
            @Suppress("UNCHECKED_CAST")
            creator.get() as T
        } catch (expected: Exception) {
            throw DaggerViewModelFactoryException(expected)
        }
    }
}

/**
 * This exception is thrown each time the [ViewModelFactory] fails to retrieve or create a [ViewModel].
 *
 * @param exception internal exception describing the failure
 */
class DaggerViewModelFactoryException(exception: Exception) : RuntimeException(exception)
