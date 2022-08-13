package cz.drekorian.android.planeswalker.lifecounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.fragment.BaseToolbarFragment
import cz.drekorian.android.planeswalker.databinding.FragmentLifeCounterBinding

/**
 * This fragment displays the life counter.
 *
 * @see LifeCounterActivity
 * @see R.navigation.navigation_life_counter
 * @author Marek Osvald
 */
class LifeCounterFragment : BaseToolbarFragment() {

    private val viewModel: LifeCounterViewModel by viewModels(
        ownerProducer = { activity as AppCompatActivity },
        factoryProducer = { viewModelFactory }
    )

    override val title: String by lazy(LazyThreadSafetyMode.NONE) {
        getString(R.string.fragment_life_counter_title)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLifeCounterBinding.inflate(inflater, container, false).also { binding ->
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }.root
}
