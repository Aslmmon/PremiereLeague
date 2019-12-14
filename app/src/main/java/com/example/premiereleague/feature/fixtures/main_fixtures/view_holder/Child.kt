package com.example.premiereleague.feature.fixtures.main_fixtures.view_holder

import com.example.core.model.Matche
import com.example.premiereleague.R
import tellh.com.recyclertreeview_lib.LayoutItemType

class Child(var  match: Matche) : LayoutItemType {



    override fun getLayoutId(): Int {
        return R.layout.match_item
    }
}