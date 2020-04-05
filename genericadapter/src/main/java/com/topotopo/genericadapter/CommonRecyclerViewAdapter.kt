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
abstract class CommonRecyclerViewAdapter(
    private val listCommon: MutableList<CommonItem<*>>
) :
    RecyclerView.Adapter<CommonViewHolder>() {

    private lateinit var onItemClickListener: (pos: Int, data: Any?, view: View) -> Unit

    fun setItemClickListener(onItemClickListener: (pos: Int, data: Any?, view: View) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        //TODO: Handle viewtype -1
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            layoutInflater, viewType, parent, false
        )
        return CommonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listCommon.size
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(listCommon[position])//TODO: Multiple different variable ID's
        holder.itemView.setOnClickListener {
            onItemClickListener.invoke(position, listCommon[position].data, holder.itemView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return listCommon[position].layoutId
    }

}