package com.topotopo.genericadapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * A generic RecyclerView.ViewHolder for the [CommonRecyclerViewAdapter]
 */
class CommonViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * Binds the declared model [CommonItemHolder.data]
     * wrapped by [CommonItemHolder] to the layout
     * @param commonItemHolder to bind
     */
    fun bind(commonItemHolder: CommonItemHolder<*>) {
        binding.setVariable(commonItemHolder.variableId, commonItemHolder.data)
        binding.executePendingBindings()
    }
}