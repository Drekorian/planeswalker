package cz.drekorian.android.planeswalker.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * This annotation denotes a unique key for ViewModel dependency injection.
 *
 * @author Marek Osvald
 */
@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
