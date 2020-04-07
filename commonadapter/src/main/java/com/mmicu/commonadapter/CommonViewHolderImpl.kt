package com.mmicu.commonadapter

import androidx.databinding.ViewDataBinding

/**
 * A generic RecyclerView.ViewHolder for the [CommonRecyclerViewAdapterImpl]
 */
internal class CommonViewHolderImpl(private val binding: ViewDataBinding) :
    CommonViewHolder(binding) {

    /**
     * Binds the declared model [CommonItemHolder.data]
     * wrapped by [CommonItemHolder] to the layout
     * @param commonItemHolder to bind
     */
    override fun bind(commonItemHolder: CommonItemHolder<*>) {
        commonItemHolder.variableId?.let { varId ->
            binding.setVariable(varId, commonItemHolder.data)
        }
        binding.executePendingBindings()
    }
}