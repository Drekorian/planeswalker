package cz.drekorian.android.planeswalker.set

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallCard

/**
 * This adapter displays a list of [ScryfallCard]s in a [RecyclerView] grid.
 *
 * @author Marek Osvald
 */
class SetAdapter(
    private val context: Context,
    private val cards: List<ScryfallCard>
) : RecyclerView.Adapter<SetViewHolder>() {

    override fun getItemCount(): Int = cards.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card_grid, parent, false)
        return SetViewHolder(view)
    }

    override fun onBindViewHolder(holder: SetViewHolder, position: Int) {
        cards[position].let { card: ScryfallCard ->
            holder.itemView.tag = card
            holder.itemView.setOnClickListener { view ->
                val selectedCard = view.tag as ScryfallCard

                view.findNavController().navigate(
                    SetFragmentDirections.showCard(
                        setCode = selectedCard.set,
                        setName = selectedCard.setName,
                        cardCollectorNumber = selectedCard.collectorNumber,
                        cardId = selectedCard.id,
                        cardName = selectedCard.name
                    )
                )
            }

            holder.image
            holder.image.load(card.primaryArtCrop) {
                placeholder(R.drawable.bg_card_grid_placeholder)
                scale(Scale.FIT)
            }

            holder.name.text = card.name
        }
    }
}

/**
 * This [RecyclerView.ViewHolder] holds a card [View]s.
 *
 * @property image [ImageView] holding a card cropped image
 * @property name [TextView] holding a card name
 */
class SetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.findViewById(R.id.image)
    val name: TextView = itemView.findViewById(R.id.name)
}
