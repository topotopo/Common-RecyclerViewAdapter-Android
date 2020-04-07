package com.mmicu.commonadapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class CommonViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(commonItemHolder: CommonItemHolder<*>)
}