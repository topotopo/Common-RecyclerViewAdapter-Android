package com.mmicu.demo.feed.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mmicu.demo.feed.domain.usecase.GetFeedHolderUseCase
import kotlinx.coroutines.Dispatchers

class FeedViewModel(private val feedHolderCase: GetFeedHolderUseCase) : ViewModel() {

    val feedList = liveData(Dispatchers.IO) {
        val response = feedHolderCase.invoke()
        emit(response)
    }
}