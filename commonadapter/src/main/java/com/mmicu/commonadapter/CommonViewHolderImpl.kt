package com.mmicu.commonadapter

import androidx.databinding.ViewDataBinding

/**
 * A generic RecyclerView.ViewHolder for the [CommonRecyclerViewAdapterImpl]
 */
class CommonViewHolderImpl private constructor(private val binding: ViewDataBinding) :
    CommonViewHolder(binding) {

    companion object {
        fun initialize(binding: ViewDataBinding): CommonViewHolderImpl {
            return CommonViewHolderImpl(binding)
        }
    }

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