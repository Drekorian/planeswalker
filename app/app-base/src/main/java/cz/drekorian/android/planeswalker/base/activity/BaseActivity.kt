package cz.drekorian.android.planeswalker.base.activity

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import cz.drekorian.android.planeswalker.base.di.BaseAppComponentHolder
import javax.inject.Inject

/**
 * This abstract class serves as a common ancestor for all application [Activity] instances.
 *
 * @author Marek Osvald
 */
abstract class BaseActivity : AppCompatActivity() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    protected open fun inject() {
        BaseAppComponentHolder.component.injectBaseActivity(this)
    }
}
