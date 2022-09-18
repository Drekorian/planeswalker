package cz.drekorian.android.planeswalker.set.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.fragment.BaseToolbarFragment
import cz.drekorian.android.planeswalker.databinding.FragmentSetListBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.stateViewModel

/**
 * This fragment displays a list of MTG sets.
 *
 * @see cz.drekorian.android.planeswalker.scryfall.ScryfallActivity
 * @see R.navigation.navigation_scryfall
 * @author Marek Osvald
 */
class SetListFragment : BaseToolbarFragment() {

    private val viewModel: SetListViewModel by stateViewModel()

    override val title: String by lazy(LazyThreadSafetyMode.NONE) {
        getString(R.string.fragment_set_list_title)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSetListBinding.inflate(inflater, container, false).also { binding ->
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchData()
    }
}
