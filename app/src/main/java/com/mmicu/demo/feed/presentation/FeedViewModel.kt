package com.mmicu.demo.feed.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mmicu.commonadapter.CommonItemHolder
import com.mmicu.demo.BR
import com.mmicu.demo.feed.domain.model.FeedModel
import com.mmicu.demo.feed.domain.model.MovieModel
import com.mmicu.demo.feed.domain.model.StatusModel
import com.mmicu.demo.feed.domain.usecase.GetFeedHolderUseCase
import com.mmicu.demo.feed.presentation.itemviewholder.Empty
import com.mmicu.demo.feed.presentation.itemviewholder.MovieFeedItemHolder
import com.mmicu.demo.feed.presentation.itemviewholder.StatusFeedItemHolder
import com.mmicu.demo.utils.Result
import kotlinx.coroutines.Dispatchers

class FeedViewModel(private val feedHolderCase: GetFeedHolderUseCase) : ViewModel() {
    private val _feedList = invokeFeedHolderLiveData()
    val feedList = _feedList

    private fun invokeFeedHolderLiveData() =
        liveData(Dispatchers.IO) {
            when (val response = feedHolderCase.invoke()) {
                is Result.Success -> {
                    emit(mapResponseToViewModel(response))
                }
                is Result.Error -> {
                } // TODO Show error message here
                is Result.Loading -> {
                } // TODO Show loading here
            }
        }

    private fun mapResponseToViewModel(response: Result.Success<List<FeedModel?>>): List<CommonItemHolder<out Any>> {
        return response.data.map {
            when (it) {
                is MovieModel -> {
                    MovieFeedItemHolder(
                        data = it,
                        variableId = BR.data
                    )
                }
                is StatusModel -> {
                    StatusFeedItemHolder(
                        data = it,
                        variableId = BR.data
                    )
                }
                else -> {
                    Empty(
                        it ?: "" //TODO: Handle nulls
                    )
                }
            }
        }
    }
}