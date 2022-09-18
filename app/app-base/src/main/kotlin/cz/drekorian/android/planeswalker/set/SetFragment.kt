package cz.drekorian.android.planeswalker.set

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.fragment.BaseToolbarFragment
import cz.drekorian.android.planeswalker.databinding.FragmentSetBinding
import org.koin.androidx.viewmodel.ext.android.stateViewModel

/**
 * This fragment displays a cards of a set.
 *
 * @see cz.drekorian.android.planeswalker.scryfall.ScryfallActivity
 * @see R.navigation.navigation_scryfall
 * @author Marek Osvald
 */
class SetFragment : BaseToolbarFragment() {

    private val viewModel: SetViewModel by stateViewModel()

    override val title: String by lazy(LazyThreadSafetyMode.NONE) {
        arguments?.getString(ARGUMENT_KEY_SET_NAME) ?: getString(R.string.fragment_set_title)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSetBinding.inflate(inflater, container, false).also { binding ->
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val code = arguments?.getString(ARGUMENT_KEY_SET_CODE) ?: return
        viewModel.fetchCards(code)
    }

    companion object {

        /**
         * Argument key for displayed set name.
         */
        const val ARGUMENT_KEY_SET_NAME = "setName"

        /**
         * Argument key for displayed set code.
         */
        const val ARGUMENT_KEY_SET_CODE = "setCode"
    }
}
