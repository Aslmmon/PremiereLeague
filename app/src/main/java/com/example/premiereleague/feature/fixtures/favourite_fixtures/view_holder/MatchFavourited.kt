package com.example.premiereleague.feature.fixtures.favourite_fixtures.view_holder

import android.view.View
import com.example.core.database.MatchDetail
import com.example.premiereleague.R
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.match_item.view.*


class MatchFavourited(val  match: MatchDetail) : Item<ViewHolder>() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.team1.text = match.homeTeam
        viewHolder.itemView.team1_result.text = match.homeResult
        viewHolder.itemView.team2.text = match.awayTeam
        viewHolder.itemView.team2_result.text = match.awayResult
        viewHolder.itemView.date.visibility = View.GONE
        viewHolder.itemView.favourite_ic.visibility = View.GONE
    }

    override fun getLayout(): Int  = R.layout.match_item


}