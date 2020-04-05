package com.topotopo.genericadapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * A generic RecyclerView.ViewHolder for the [CommonRecyclerViewAdapter]
 */
class CommonViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * Binds the declared model [CommonItem.data]
     * wrapped by [CommonItem] to the layout
     * @param commonItem to bind
     */
    fun bind(commonItem: CommonItem<*>) {
        binding.setVariable(commonItem.variableId, commonItem.data)
        binding.executePendingBindings()
    }
}