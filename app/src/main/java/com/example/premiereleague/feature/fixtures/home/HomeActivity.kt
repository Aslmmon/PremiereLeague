package com.example.premiereleague.feature.fixtures.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.core.model.Matche
import com.example.premiereleague.R
import com.example.premiereleague.common.Utils
import com.example.premiereleague.feature.fixtures.home.view_binder.ChildBinder
import com.example.premiereleague.feature.fixtures.home.view_binder.ParentBinder
import com.example.premiereleague.feature.fixtures.home.view_holder.Child
import com.example.premiereleague.feature.fixtures.home.view_holder.MatchViewHolder
import com.example.premiereleague.feature.fixtures.home.view_holder.Parent
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_main_fixtures.*
import org.koin.android.viewmodel.ext.android.viewModel
import tellh.com.recyclertreeview_lib.TreeNode
import tellh.com.recyclertreeview_lib.TreeViewAdapter
import java.util.ArrayList

class HomeActivity : AppCompatActivity(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModel()
    val adapter = GroupAdapter<ViewHolder>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.getMatchDetails()
        mainViewModel.MatchDetail.observe(this, Observer {
            adapter.clear()
            it.matches.take(5).forEach {
                Log.i(javaClass.simpleName,it.homeTeamInfo.crestUrl)
                adapter.add(MatchViewHolder(it))
            }

            match_recycler.adapter = adapter
        })
    }
}
