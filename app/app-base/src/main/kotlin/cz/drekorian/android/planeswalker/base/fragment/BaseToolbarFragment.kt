package cz.drekorian.android.planeswalker.base.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import cz.drekorian.android.planeswalker.R

/**
 * This abstract class serves as the common ancestor for all fragments that display a [Toolbar].
 *
 * @author Marek Osvald
 */
abstract class BaseToolbarFragment : BaseFragment() {

    @Suppress("MemberVisibilityCanBePrivate")
    protected lateinit var toolbar: Toolbar
        private set

    /**
     * Stores fragment's title
     */
    abstract val title: String

    /**
     * Stores fragment's subtitle.
     */
    open val subtitle: String? = null

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar = view.findViewById(R.id.toolbar)
        toolbar.title = title
        subtitle?.let { subtitle -> toolbar.subtitle = subtitle }
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }
}
