package com.topotopo.genericadapter

import android.view.View


interface CommonItemHolder<T> {
    var data: T?
    var layoutId: Int
    var variableId: Int

    fun onBindViewHolder(itemView: View) {

    }
}
