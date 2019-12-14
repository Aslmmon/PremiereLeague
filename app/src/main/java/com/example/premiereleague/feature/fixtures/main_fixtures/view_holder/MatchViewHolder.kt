package com.example.premiereleague.feature.fixtures.main_fixtures.view_holder

import android.annotation.SuppressLint
import android.util.Log
import android.widget.ImageView
import com.example.core.model.Matche
import com.example.premiereleague.R
import com.example.premiereleague.common.Constants
import com.example.premiereleague.common.Utils
import com.varunest.sparkbutton.SparkEventListener
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.match_item.view.*

/**
 * This class not used anymore as TreeRecyclerView Library is used now
 * this viewHolder was used by Groupie Adapter
 * befor using expandble RecyclerViews
 */

class MatchViewHolder(val match: Matche, val heart: OnHeartClickedListener) : Item<ViewHolder>() {

    interface OnHeartClickedListener {
        fun onHeartClicked(match: Matche)
    }

    @SuppressLint("SetTextI18n")
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.date.text = "Date : ${match.newDate}"
        if (!match.status.contentEquals(Constants.FINISHED_STATUS)) {
            if (match.status.contentEquals(Constants.IN_PLAY_STATUS)) {
                viewHolder.itemView.time_match.text = "Playing Now"
            } else {
                viewHolder.itemView.time_match.text = "Schecduled at  ${match.newTime}"
            }
        }
        if (match.isFavourited) {
            viewHolder.itemView.favourite_ic.isActivated
        }else{
            !viewHolder.itemView.favourite_ic.isActivated
        }
        viewHolder.itemView.team1.text = match.homeTeam.name
        viewHolder.itemView.team1_result.text = match.score.fullTime.homeTeam
        viewHolder.itemView.team2.text = match.awayTeam.name
        viewHolder.itemView.team2_result.text = match.score.fullTime.awayTeam
        viewHolder.itemView.favourite_ic.setEventListener(object : SparkEventListener {
            override fun onEvent(button: ImageView?, buttonState: Boolean) {
                if (buttonState) {
                    heart.onHeartClicked(match)
                }
            }

            override fun onEventAnimationStart(button: ImageView?, buttonState: Boolean) {}
            override fun onEventAnimationEnd(button: ImageView?, buttonState: Boolean) {}
        })

    }

    override fun getLayout(): Int = R.layout.match_item


}