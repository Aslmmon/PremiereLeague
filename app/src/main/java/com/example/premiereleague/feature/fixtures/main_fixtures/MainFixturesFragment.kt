package com.example.premiereleague.feature.fixtures.main_fixtures


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.core.model.Matche
import com.example.premiereleague.R
import com.example.premiereleague.common.Utils
import com.example.premiereleague.feature.fixtures.home.MainViewModel
import com.example.premiereleague.feature.fixtures.main_fixtures.view_binder.ChildBinder
import com.example.premiereleague.feature.fixtures.main_fixtures.view_binder.ParentBinder
import com.example.premiereleague.feature.fixtures.main_fixtures.view_holder.Child
import com.example.premiereleague.feature.fixtures.main_fixtures.view_holder.Parent
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_main_fixtures.*
import org.koin.android.viewmodel.ext.android.viewModel
import tellh.com.recyclertreeview_lib.TreeNode
import tellh.com.recyclertreeview_lib.TreeViewAdapter
import java.util.ArrayList


class MainFixturesFragment : Fragment() {


    /**
     * MainFix. View Model instaniated By Koin @start
     */
    private val mainFixturesViewModel: MainViewModel by viewModel()
    val adapter = GroupAdapter<ViewHolder>()
    private var treeAdapter: TreeViewAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Home"

        val view = inflater.inflate(R.layout.fragment_main_fixtures, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var currentDate = Utils.getCurrentDate()
        mainFixturesViewModel.getMatchDetails()
        mainFixturesViewModel.MatchDetail.observe(this, Observer {
            adapter.clear()
            val nodes = ArrayList<TreeNode<*>>()
            var newMatch = it.matches.filter { (currentDate <= it.utcDate) }.groupBy { it.newDate }
            newMatch.forEach { (date, list) ->
                val app = TreeNode(Parent(date = date))
                nodes.add(app)
                list.forEach { match ->
                    app.addChild(TreeNode(Child(match)))
                }
            }

            treeAdapter = TreeViewAdapter(
                nodes,
                listOf(ChildBinder(object : ChildBinder.OnHeartClickedListener {
                    override fun onHeartClicked(match: Matche) {
                       // mainFixturesViewModel.saveToDatabase(match)
                        match.isFavourited = true
                    }

                }), ParentBinder())
            )
            treeAdapter?.setOnTreeNodeListener(object : TreeViewAdapter.OnTreeNodeListener {
                override fun onClick(node: TreeNode<*>, holder: RecyclerView.ViewHolder?): Boolean {
                    if (!node.isLeaf) {
                        onToggle(!node.isExpand, holder)
                    }
                    return false
                }

                override fun onToggle(isExpand: Boolean, holder: RecyclerView.ViewHolder?) {
                    val dirViewHolder = holder as ParentBinder.ViewHolder
                    val ivArrow = dirViewHolder.ivArrow
                    val rotateDegree = if (isExpand) 90 else -90
                    ivArrow.animate().rotationBy(rotateDegree.toFloat())
                        .start()
                }

            })
            match_recycler.adapter = treeAdapter

        })

    }
}
