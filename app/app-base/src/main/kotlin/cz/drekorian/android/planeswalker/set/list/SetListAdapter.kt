package cz.drekorian.android.planeswalker.set.list

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.decode.SvgDecoder
import coil.imageLoader
import coil.load
import coil.size.Scale
import cz.drekorian.android.planeswalker.R
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallSet
import cz.drekorian.android.planeswalker.set.SetFragment
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

/**
 * This adapter handles displaying [ScryfallSet] in a [RecyclerView].
 *
 * @see ScryfallSet
 * @see R.navigation.navigation_scryfall
 * @author Marek Osvald
 */
class SetListAdapter(
    private val context: Context,
    private val sets: List<ScryfallSet>,
) : RecyclerView.Adapter<ScryfallSetViewHolder>() {

    private val imageLoader = context.imageLoader.newBuilder()
        .components { add(SvgDecoder.Factory()) }
        .build()

    override fun getItemCount(): Int = sets.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScryfallSetViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_set, parent, false)
        return ScryfallSetViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ScryfallSetViewHolder, position: Int) {
        sets[position].let { set ->
            holder.itemView.tag = set
            holder.itemView.setOnClickListener { view ->
                view.findNavController().navigate(
                    R.id.show_set,
                    bundleOf(
                        SetFragment.ARGUMENT_KEY_SET_CODE to set.code,
                        SetFragment.ARGUMENT_KEY_SET_NAME to set.name
                    )
                )
            }
            holder.title.text = set.name
            holder.releasedAt.text =
                set.releasedAt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))

            val typedValue = TypedValue()
            context.theme.resolveAttribute(R.attr.colorOnSurface, typedValue, false)
            val color = typedValue.data
            holder.icon.load(
                data = set.iconSvgUri,
                imageLoader = imageLoader,
            ) {
                scale(Scale.FIT)
                crossfade(true)
                transformations(listOf())
                //tint(color)
                println(color)
            }
        }
    }
}

/**
 * This [RecyclerView.ViewHolder] stores [View]s of a [ScryfallSet] UI representation.
 *
 * @property title [TextView] holding [ScryfallSet] name
 * @property releasedAt [TextView] holding [ScryfallSet] release date
 * @property icon [ImageView] holding [ScryfallSet] icon
 */
class ScryfallSetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.name)
    val releasedAt: TextView = itemView.findViewById(R.id.released_at)
    val icon: ImageView = itemView.findViewById(R.id.icon)
}
