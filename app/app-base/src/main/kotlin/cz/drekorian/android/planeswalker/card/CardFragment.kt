package cz.drekorian.android.planeswalker.card

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import coil.load
import coil.size.Scale
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.fragment.BaseToolbarFragment
import cz.drekorian.android.planeswalker.databinding.FragmentCardBinding
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCard
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import java.util.Locale

/**
 * This fragment displays detailed information about a single card.
 *
 * @author Marek Osvald
 */
class CardFragment : BaseToolbarFragment() {

    private val viewModel: CardViewModel by stateViewModel()

    private lateinit var vImage: ImageView

    override val title: String by lazy(LazyThreadSafetyMode.NONE) {
        arguments?.getString(ARGUMENT_KEY_CARD_NAME) ?: getString(R.string.fragment_card_title)
    }

    override val subtitle: String? by lazy(LazyThreadSafetyMode.NONE) {
        val setCode = arguments?.getString(ARGUMENT_KEY_SET_CODE) ?: return@lazy null
        val setName = arguments?.getString(ARGUMENT_KEY_SET_NAME) ?: return@lazy null
        val collectorNumber =
            arguments?.getString(ARGUMENT_KEY_CARD_COLLECTOR_NUMBER) ?: return@lazy null
        "$setName (${setCode.uppercase(Locale.getDefault())}) #$collectorNumber"
    }

    private val cardFlipHelper: CardFlipHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchCard(arguments?.getString(ARGUMENT_KEY_CARD_ID) ?: return)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCardBinding.inflate(inflater, container, false).also { binding ->
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        vImage = binding.image
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.card.observe(viewLifecycleOwner, Observer { card: ScryfallCard? ->
            if (card == null) {
                return@Observer
            }

            cardFlipHelper.initialize(card, vImage)
            vImage.load(card.primaryPng) {
                scale(Scale.FIT)
                placeholder(R.drawable.card_back)
                crossfade(true)
                listener(
                    onSuccess = { _, _ ->
                        vImage.setOnClickListener { cardFlipHelper.flip() }
                    },
                )
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_card, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId != R.id.scryfall) {
            return false
        }

        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(viewModel.card.value?.scryfallUri ?: return false)
        )
        context?.startActivity(intent)
        return true
    }

    companion object {

        const val ARGUMENT_KEY_CARD_COLLECTOR_NUMBER = "cardCollectorNumber"
        const val ARGUMENT_KEY_CARD_ID = "cardId"
        const val ARGUMENT_KEY_CARD_NAME = "cardName"
        const val ARGUMENT_KEY_SET_NAME = "setName"
        const val ARGUMENT_KEY_SET_CODE = "setCode"
    }
}
