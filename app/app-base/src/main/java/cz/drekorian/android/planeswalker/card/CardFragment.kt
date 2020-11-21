package cz.drekorian.android.planeswalker.card

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.base.di.BaseAppComponentHolder
import cz.drekorian.android.planeswalker.base.fragment.BaseToolbarFragment
import cz.drekorian.android.planeswalker.databinding.FragmentCardBinding
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCard
import java.util.*
import javax.inject.Inject

/**
 * This fragment displays detailed information about a single card.
 *
 * @author Marek Osvald
 */
class CardFragment() : BaseToolbarFragment() {

    private val viewModel: CardViewModel by viewModels { viewModelFactory }

    private lateinit var vImage: ImageView

    override val title: String by lazy(LazyThreadSafetyMode.NONE) {
        arguments?.getString(ARGUMENT_KEY_CARD_NAME) ?: getString(R.string.fragment_card_title)
    }

    override val subtitle: String? by lazy(LazyThreadSafetyMode.NONE) {
        val setCode = arguments?.getString(ARGUMENT_KEY_SET_CODE) ?: return@lazy null
        val setName = arguments?.getString(ARGUMENT_KEY_SET_NAME) ?: return@lazy null
        val collectorNumber =
            arguments?.getString(ARGUMENT_KEY_CARD_COLLECTOR_NUMBER) ?: return@lazy null
        "$setName (${setCode.toUpperCase(Locale.getDefault())}) #$collectorNumber"
    }

    @Inject
    lateinit var picasso: Picasso

    @Inject
    lateinit var cardFlipHelper: CardFlipHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchCard(arguments?.getString(ARGUMENT_KEY_CARD_ID) ?: return)
        setHasOptionsMenu(true)
    }

    override fun inject() {
        BaseAppComponentHolder.component.injectCardFragment(this)
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
            picasso
                .load(card.primaryPng)
                .placeholder(R.drawable.card_back)
                .fit()
                .centerCrop()
                .into(vImage, object : Callback {
                    override fun onSuccess() {
                        vImage.isClickable = true
                        vImage.setOnClickListener { cardFlipHelper.flip() }
                    }

                    override fun onError(e: Exception?) { /* no-op */
                    }
                })
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
