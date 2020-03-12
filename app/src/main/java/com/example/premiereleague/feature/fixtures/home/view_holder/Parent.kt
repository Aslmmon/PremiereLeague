package com.example.premiereleague.feature.fixtures.home.view_holder

import com.example.premiereleague.R
import tellh.com.recyclertreeview_lib.LayoutItemType

class Parent (val date:String): LayoutItemType {
    override fun getLayoutId(): Int {
        return R.layout.item_parent
    }
}