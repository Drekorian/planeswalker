package cz.drekorian.android.planeswalker.set.list

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import cz.drekorian.android.planeswalker.base.di.BaseAppComponentHolder
import cz.drekorian.android.planeswalker.scryfall.api.ApiResponse
import cz.drekorian.android.planeswalker.scryfall.api.ScryfallApi
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallSet
import cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallSetList
import cz.drekorian.android.planeswalker.util.mapApiResponse
import cz.drekorian.android.planeswalker.util.mapApiResponseList
import javax.inject.Inject

/**
 * This view model handles [SetListFragment] business logic.
 *
 * @see cz.drekorian.android.planeswalker.scryfall.ScryfallActivity
 * @see SetListFragment
 * @author Marek Osvald
 */
class SetListViewModel @Inject constructor(private val scryfallApi: ScryfallApi) : ViewModel() {

    private lateinit var setsApiResponse: LiveData<ApiResponse<ScryfallSetList>>

    /**
     * Stores set list.
     */
    val sets: LiveData<List<ScryfallSet>> by lazy(LazyThreadSafetyMode.NONE) {
        setsApiResponse.mapApiResponseList()
    }

    /**
     * Fetches set list form Scryfall API.
     */
    fun fetchData() {
        setsApiResponse = scryfallApi.getSets()
    }
}

/**
 * Binds a new [SetListAdapter] containing [list] onto the [recyclerView].
 *
 * @param recyclerView [RecyclerView] host
 * @param list list of [ScryfallSet]s
 */
@BindingAdapter("adapter")
fun setAdapter(recyclerView: RecyclerView, list: List<ScryfallSet>?) {
    if (list == null) {
        return
    }

    val component = BaseAppComponentHolder.component
    recyclerView.adapter = SetListAdapter(
        context = recyclerView.context,
        sets = list,
        svgApi = component.svgApi()
    )
}
