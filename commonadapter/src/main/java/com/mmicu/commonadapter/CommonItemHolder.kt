package com.mmicu.commonadapter

import android.view.View

/**
 * Represents one item type in the list.
 */
interface CommonItemHolder<T> {

    /**
     * The data to bind in the view [layoutId]
     */
    var data: T?

    /**
     * The xml layout id of an item view type.
     */
    var layoutId: Int

    /**
     * The variable declared name of [data] in the view [layoutId] for databinding.
     */
    var variableId: Int?

    fun onBindViewHolder(itemView: View) {

    }
}
