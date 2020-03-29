package com.topotopo.demo.feed.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.topotopo.demo.BR
import com.topotopo.demo.R
import com.topotopo.demo.databinding.FragmentFeedBinding
import com.topotopo.genericadapter.GenericAdapter
import com.topotopo.genericadapter.GenericItemViewHolder
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.core.KoinComponent

class FeedFragment : Fragment(),
    KoinComponent {

    private val sampleMovieList = mutableListOf<GenericItemViewHolder<*>>()
    private lateinit var binding: FragmentFeedBinding
    private lateinit var adapter: GenericAdapter

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

        adapter = GenericAdapter(
            sampleMovieList,
            BR.data
        )
        adapter.onItemClickListener = { pos, data, view ->
            Toast.makeText(
                context,
                "Item clicked $pos",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.rvFeed.layoutManager =
            LinearLayoutManager(context)
        binding.rvFeed.adapter = adapter

        addObservers()
    }

    private fun addObservers() {
        feedViewModel.feedList.observe(this, Observer {
            sampleMovieList.clear()
            sampleMovieList.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }
}