package com.topotopo.genericadapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * A generic RecyclerView.ViewHolder for the [GenericAdapter]
 */
class GenericViewHolder(private val binding: ViewDataBinding, val variableId: Int) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * Binds the declared model [GenericItemViewHolder.data]
     * wrapped by [GenericItemViewHolder] to the layout
     * @param commonItem to bind
     */
    fun bind(commonItem: GenericItemViewHolder<*>) {
        binding.setVariable(variableId, commonItem.data)
        binding.executePendingBindings()
    }
}