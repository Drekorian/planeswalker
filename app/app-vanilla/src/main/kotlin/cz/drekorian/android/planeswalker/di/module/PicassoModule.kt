package cz.drekorian.android.planeswalker.di.module

import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This module provides Picasso-related dependencies.
 */
@Module
class PicassoModule {

    @Provides
    @Singleton
    fun providePicasso(): Picasso = Picasso.get()
}
