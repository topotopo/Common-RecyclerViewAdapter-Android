package com.mmicu.commonadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

class CommonRecyclerViewAdapterImpl private constructor(
    private val listCommonHolder: MutableList<CommonItemHolder<*>>
) {

    companion object {
        fun initialize(listCommonHolder: MutableList<CommonItemHolder<*>>): CommonRecyclerViewAdapterImpl {
            return CommonRecyclerViewAdapterImpl(listCommonHolder)
        }
    }

    private lateinit var onItemClickListener: (pos: Int, data: Any?, view: View) -> Unit

    fun setItemClickListener(onItemClickListener: (pos: Int, data: Any?, view: View) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        //TODO: Handle viewtype -1
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            layoutInflater, viewType, parent, false
        )
        return CommonViewHolderImpl.initialize(binding)
    }

    fun getItemCount(): Int {
        return listCommonHolder.size
    }

    fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(listCommonHolder[position])
        listCommonHolder[position].onBindViewHolder(holder.itemView)
        holder.itemView.setOnClickListener {
            onItemClickListener.invoke(position, listCommonHolder[position].data, holder.itemView)
        }
    }

    fun getItemViewType(position: Int): Int {
        return listCommonHolder[position].layoutId
    }

}