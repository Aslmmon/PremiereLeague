package com.example.premiereleague.feature.fixtures.favourite_fixtures


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.premiereleague.R
import com.example.premiereleague.feature.fixtures.favourite_fixtures.view_holder.MatchFavourited
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_favourite_fixtures.*
import org.koin.android.viewmodel.ext.android.viewModel

class FavouriteFixturesFragment : Fragment() {

    private val favouriteFixtureViewModel: FavouriteFixtureViewModel by viewModel()
    val adapter = GroupAdapter<ViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Favourites"
        return inflater.inflate(R.layout.fragment_favourite_fixtures, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favouriteFixtureViewModel.getMatchesFavourited()
        favouriteFixtureViewModel.MatchesFavourited.observe(this, Observer { list ->
            if (list.isEmpty()) no_favourites_tv.visibility = View.VISIBLE
            else {
                adapter.clear()
                list.forEach {
                    adapter.add(MatchFavourited(it))
                }
                match_favourites_rv.adapter = adapter
            }
        })
    }
}
