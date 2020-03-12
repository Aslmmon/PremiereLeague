package com.example.premiereleague.feature.fixtures.home.view_holder

import android.annotation.SuppressLint
import android.app.Activity
import com.ahmadrosid.svgloader.SvgLoader
import com.example.core.model.Matche
import com.example.premiereleague.R
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.match_item.view.*

/**
 * This class not used anymore as TreeRecyclerView Library is used now
 * this viewHolder was used by Groupie Adapter
 * befor using expandble RecyclerViews
 */

class MatchViewHolder(val match: Matche) : Item<ViewHolder>() {

    @SuppressLint("SetTextI18n")
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.date.text = "Date : ${match.newDate}"
        viewHolder.itemView.team1.text = match.homeTeam.name
        viewHolder.itemView.team1_result.text = match.score.fullTime.homeTeam
        viewHolder.itemView.team2.text = match.awayTeam.name
        viewHolder.itemView.team2_result.text = match.score.fullTime.awayTeam
        SvgLoader.pluck()
            .with(viewHolder.itemView.iv_home.context as Activity)
            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
            .load(match.homeTeamInfo.crestUrl, viewHolder.itemView.iv_home);

        SvgLoader.pluck()
            .with(viewHolder.itemView.iv_away.context as Activity)
            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
            .load(match.awayTeamInfo.crestUrl, viewHolder.itemView.iv_away);

    }
    override fun getLayout(): Int = R.layout.match_item

}