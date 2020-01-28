package com.topotopo.genericadapterdemo.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.topotopo.genericadapter.GenericItemViewHolder
import com.topotopo.genericadapterdemo.feed.itemviewholder.EmptyViewHolder
import com.topotopo.genericadapterdemo.feed.itemviewholder.MovieFeedViewHolder
import com.topotopo.genericadapterdemo.feed.itemviewholder.StatusFeedViewHolder
import com.topotopo.genericadapterdemo.model.MovieModel
import com.topotopo.genericadapterdemo.model.StatusModel
import com.topotopo.genericadapterdemo.repo.FeedRepository
import kotlinx.coroutines.Dispatchers

class FeedViewModel(private val feedRepo: FeedRepository) : ViewModel() {

    val feedList = liveData(Dispatchers.IO) {
        val movies: List<GenericItemViewHolder<*>> = feedRepo.fetchAllFeed().map {
            when (it) {
                is MovieModel -> MovieFeedViewHolder(it)
                is StatusModel -> StatusFeedViewHolder(it)
                else -> EmptyViewHolder(it)
            }
        }
        emit(movies)
    }
}