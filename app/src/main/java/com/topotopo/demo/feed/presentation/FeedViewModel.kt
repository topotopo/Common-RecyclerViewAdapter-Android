package com.topotopo.demo.feed.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.topotopo.demo.feed.domain.usecase.GetFeedHolderUseCase
import kotlinx.coroutines.Dispatchers

class FeedViewModel(private val feedHolderCase: GetFeedHolderUseCase) : ViewModel() {

    val feedList = liveData(Dispatchers.IO) {
        val response = feedHolderCase.invoke()
        emit(response)
    }
//    val feedList = liveData(Dispatchers.IO) {
//        val movies: List<GenericItemViewHolder<*>> = feedRepo.fetchAllFeed().map {
//            when (it) {
//                is MovieModel -> MovieFeedViewHolder(
//                    it
//                )
//                is StatusModel -> StatusFeedViewHolder(
//                    it
//                )
//                else -> EmptyViewHolder(
//                    it
//                )
//            }
//        }
//        emit(movies)
//    }
}