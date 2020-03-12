package com.example.premiereleague.feature.fixtures.home.view_binder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.premiereleague.R
import com.example.premiereleague.feature.fixtures.home.view_holder.Parent
import tellh.com.recyclertreeview_lib.TreeNode
import tellh.com.recyclertreeview_lib.TreeViewBinder


class ParentBinder : TreeViewBinder<ParentBinder.ViewHolder>() {
    override fun provideViewHolder(itemView: View): ViewHolder {
        return ViewHolder(itemView)
    }

    override fun bindView(holder: ViewHolder, position: Int, node: TreeNode<*>) {
        holder.ivArrow.rotation = 0f
        holder.ivArrow.setImageResource(R.drawable.ic_chevron)
        val rotateDegree = if (node.isExpand) 90 else 0
        holder.ivArrow.rotation = rotateDegree.toFloat()
        val mainNode = node.content as Parent
        holder.tvName.text = mainNode.date
        if (node.isLeaf)
            holder.ivArrow.visibility = View.INVISIBLE
        else
            holder.ivArrow.visibility = View.VISIBLE
    }

    override fun getLayoutId(): Int {
        return R.layout.item_parent
    }

    class ViewHolder(rootView: View) : TreeViewBinder.ViewHolder(rootView) {
        val ivArrow: ImageView = rootView.findViewById(R.id.iv_arrow) as ImageView
        val tvName: TextView = rootView.findViewById(R.id.tv_date) as TextView

    }
}
