package com.mmicu.commonadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * A generic adapter to be used in RecyclerView with different models and UI @constructor
 * Creates a new GenericAdapter instance
 * @param listCommonHolder list of item with the declared model and layout id
 */
abstract class CommonRecyclerViewAdapter(
    listCommonHolder: MutableList<CommonItemHolder<*>>
) : RecyclerView.Adapter<CommonViewHolder>() {

    private val commonRecyclerViewAdapter = CommonRecyclerViewAdapterImpl.initialize(listCommonHolder)

    /**
     * Sets a listener invoked when an item is clicked
     */
    fun setItemClickListener(onItemClickListener: (pos: Int, data: Any?, view: View) -> Unit) {
        commonRecyclerViewAdapter.setItemClickListener(onItemClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return commonRecyclerViewAdapter.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return commonRecyclerViewAdapter.getItemCount()
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        return commonRecyclerViewAdapter.onBindViewHolder(holder, position)
    }

    override fun getItemViewType(position: Int): Int {
        return commonRecyclerViewAdapter.getItemViewType(position)
    }
}