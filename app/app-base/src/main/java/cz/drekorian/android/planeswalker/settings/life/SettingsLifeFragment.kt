package cz.drekorian.android.planeswalker.settings.life

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.databinding.BindingAdapter
import androidx.fragment.app.viewModels
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.fragment.BaseToolbarFragment
import cz.drekorian.android.planeswalker.databinding.FragmentSettingsLifeBinding
import cz.drekorian.android.planeswalker.settings.SettingsManager

/**
 * This fragment displays the Life Counter settings.
 *
 * @see cz.drekorian.android.planeswalker.settings.SettingsActivity
 * @see R.navigation.navigation_settings
 * @author Marek Osvald
 */
class SettingsLifeFragment : BaseToolbarFragment() {

    private val viewModel: SettingsLifeViewModel by viewModels { viewModelFactory }

    override val title: String by lazy(LazyThreadSafetyMode.NONE) {
        getString(R.string.fragment_settings_life_title)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSettingsLifeBinding.inflate(inflater, container, false).also { binding ->
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }.root
}

/**
 * Binds persisted default life count onto given [RadioGroup].
 *
 * @param radioGroup [RadioGroup] instance displaying user preference
 * @param lifeCount user selected default life count
 */
@BindingAdapter("lifeCount")
fun setLifeCount(radioGroup: RadioGroup, lifeCount: Int) {
    require(lifeCount in SettingsManager.ALLOWED_LIFE_COUNTS) { "Invalid life count: $lifeCount " }
    radioGroup.check(
        when (lifeCount) {
            SettingsManager.DEFAULT_LIFE_COUNT_STANDARD -> R.id.standard
            SettingsManager.DEFAULT_LIFE_COUNT_BRAWL -> R.id.brawl
            else -> R.id.commander
        }
    )
}
