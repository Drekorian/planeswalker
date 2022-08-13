package cz.drekorian.android.planeswalker.base.fragment

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cz.drekorian.android.planeswalker.base.di.BaseAppComponentHolder
import javax.inject.Inject

/**
 * This abstract class serves as the common ancestor for all [Fragment]s.
 *
 * @author Marek Osvald
 */
abstract class BaseFragment : Fragment() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    /**
     * Injects Dagger dependencies.
     */
    open fun inject() {
        BaseAppComponentHolder.component.injectBaseFragment(this)
    }
}
