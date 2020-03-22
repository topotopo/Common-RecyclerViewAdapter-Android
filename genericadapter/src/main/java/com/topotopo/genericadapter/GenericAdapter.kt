package com.topotopo.genericadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.View

/**
 * A generic adapter to be used in RecyclerView with different models and UI @constructor
 * Creates a new GenericAdapter instance
 * @param listCommon list of item with the declared model and layout id
 */
open class GenericAdapter(private val listCommon: MutableList<GenericItemViewHolder<*>>, private val variableId: Int) :
    RecyclerView.Adapter<GenericViewHolder>() {

    var onItemClickListener: ((pos: Int, data: Any?, view: View) -> Unit?)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            layoutInflater, viewType, parent, false
        )
        return GenericViewHolder(binding, variableId)
    }

    override fun getItemCount(): Int {
        return listCommon.size
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.bind(listCommon[position])
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(position, listCommon[position].data, holder.itemView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return listCommon[position].layoutId
    }

}