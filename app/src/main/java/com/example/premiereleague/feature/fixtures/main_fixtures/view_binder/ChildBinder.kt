package com.example.premiereleague.feature.fixtures.main_fixtures.view_binder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.core.model.Matche
import com.example.premiereleague.R
import com.example.premiereleague.common.Constants
import com.example.premiereleague.common.Utils
import com.example.premiereleague.feature.fixtures.main_fixtures.view_holder.Child
import com.example.premiereleague.feature.fixtures.main_fixtures.view_holder.MatchViewHolder
import com.varunest.sparkbutton.SparkButton
import com.varunest.sparkbutton.SparkEventListener
import kotlinx.android.synthetic.main.match_item.view.*
import tellh.com.recyclertreeview_lib.TreeNode
import tellh.com.recyclertreeview_lib.TreeViewBinder

class ChildBinder(val heart: ChildBinder.OnHeartClickedListener) : TreeViewBinder<ChildBinder.ViewHolder>() {


    interface OnHeartClickedListener {
        fun onHeartClicked(match: Matche)
    }


    override fun provideViewHolder(itemView: View): ViewHolder {
        return ViewHolder(itemView)
    }

    override fun bindView(holder: ViewHolder, position: Int, node: TreeNode<*>) {

        val childNode = node.content as Child
        var match = childNode.match
        holder.tvName_date.text = childNode.match.newDate
        if (!match.status.contentEquals(Constants.FINISHED_STATUS)) {
            if (match.status.contentEquals(Constants.IN_PLAY_STATUS)) {
                holder.tv_time_match.text = "Playing Now"
            } else {
                holder.tv_time_match.text = "Scheduled at  ${match.newTime}"
            }
        }
//        if (match.isFavourited) {
//            holder.iv_heart.isEnabled
//        } else {
//            holder.iv_heart.setInactiveImage(R.drawable.arrow)
//        }
        holder.tvName_team1.text = match.homeTeam.name
        holder.tv_team1_result.text = match.score.fullTime.homeTeam
        holder.tvName_team2.text = match.awayTeam.name
        holder.tv_team2_result.text = match.score.fullTime.awayTeam
        holder.iv_heart.setEventListener(object : SparkEventListener {
            override fun onEvent(button: ImageView?, buttonState: Boolean) {
                if (buttonState) {
                    heart.onHeartClicked(match)
                }
            }

            override fun onEventAnimationStart(button: ImageView?, buttonState: Boolean) {}
            override fun onEventAnimationEnd(button: ImageView?, buttonState: Boolean) {}
        })

    }

    override fun getLayoutId(): Int {
        return R.layout.match_item
    }

    class ViewHolder(rootView: View) : TreeViewBinder.ViewHolder(rootView) {
        val tvName_date: TextView = rootView.findViewById(R.id.date) as TextView
        val tvName_team1: TextView = rootView.findViewById(R.id.team1) as TextView
        val tv_team1_result: TextView = rootView.findViewById(R.id.team1_result) as TextView
        val tv_team2_result: TextView = rootView.findViewById(R.id.team2_result) as TextView
        val tvName_team2: TextView = rootView.findViewById(R.id.team2) as TextView
        val tv_time_match: TextView = rootView.findViewById(R.id.time_match) as TextView
        val iv_heart: SparkButton = rootView.findViewById(R.id.favourite_ic) as SparkButton
    }
}