package cz.drekorian.android.planeswalker.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.fragment.BaseToolbarFragment
import cz.drekorian.android.planeswalker.databinding.FragmentSettingsBinding
import org.koin.androidx.viewmodel.ext.android.stateViewModel

/**
 * This fragment displays the user settings.
 *
 * @see R.navigation.navigation_settings
 * @see SettingsActivity
 * @author Marek Osvald
 */
class SettingsFragment : BaseToolbarFragment() {

    private val viewModel: SettingsViewModel by stateViewModel()

    override val title: String by lazy(LazyThreadSafetyMode.NONE) {
        getString(R.string.fragment_settings_title)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSettingsBinding.inflate(inflater, container, false).also { binding ->
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }.root
}
