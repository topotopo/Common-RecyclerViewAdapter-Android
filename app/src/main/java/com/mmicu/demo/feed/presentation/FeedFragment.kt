package com.mmicu.demo.feed.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmicu.demo.R
import com.mmicu.demo.core.AppRecyclerViewAdapter
import com.mmicu.demo.databinding.FragmentFeedBinding
import com.mmicu.commonadapter.CommonItemHolder
import com.mmicu.commonadapter.CommonRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.core.KoinComponent

class FeedFragment : Fragment(),
    KoinComponent {

    private val sampleMovieList = mutableListOf<CommonItemHolder<*>>()
    private lateinit var binding: FragmentFeedBinding
    private lateinit var recyclerViewAdapter: CommonRecyclerViewAdapter

    private val feedViewModel: FeedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_feed, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewAdapter = AppRecyclerViewAdapter(
            sampleMovieList
        )

        recyclerViewAdapter.setItemClickListener { pos, data, view ->
            Toast.makeText(
                context,
                "Item clicked $pos",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.rvFeed.layoutManager =
            LinearLayoutManager(context)
        binding.rvFeed.adapter = recyclerViewAdapter

        addObservers()
    }

    private fun addObservers() {
        feedViewModel.feedList.observe(this, Observer {
            sampleMovieList.clear()
            sampleMovieList.addAll(it)
            recyclerViewAdapter.notifyDataSetChanged()
        })
    }
}