package cz.drekorian.android.planeswalker.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import coil.load
import coil.size.Scale
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.di.BaseAppComponentHolder
import cz.drekorian.android.planeswalker.base.fragment.BaseToolbarFragment
import cz.drekorian.android.planeswalker.databinding.FragmentMainBinding

/**
 * This fragment displays the main application actions.
 *
 * @see MainActivity
 * @see R.navigation.navigation_main
 * @author Marek Osvald
 */
class MainFragment : BaseToolbarFragment() {

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override val title: String by lazy(LazyThreadSafetyMode.NONE) { getString(R.string.app_name) }

    private lateinit var vImage: ImageView

    override fun inject() {
        BaseAppComponentHolder.component.injectMainFragment(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMainBinding.inflate(inflater, container, false).also { binding ->
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        vImage = binding.image
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.randomCard.observe(viewLifecycleOwner) { card ->
            vImage.load(card.primaryPng) {
                placeholder(R.drawable.card_back)
                scale(Scale.FIT)
                crossfade(true)
                // centerCrop()
            }
        }
    }
}
