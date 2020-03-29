package com.topotopo.demo.feed.domain.usecase

import com.topotopo.demo.feed.domain.model.MovieModel
import com.topotopo.demo.feed.domain.model.StatusModel
import com.topotopo.demo.feed.presentation.itemviewholder.EmptyViewHolder
import com.topotopo.demo.feed.presentation.itemviewholder.MovieFeedViewHolder
import com.topotopo.demo.feed.presentation.itemviewholder.StatusFeedViewHolder
import com.topotopo.demo.utils.Result
import com.topotopo.genericadapter.GenericItemViewHolder

class GetFeedHolderUseCaseImpl(private val getFeedUseCase: GetFeedUseCase) : GetFeedHolderUseCase {
    override suspend fun invoke(): List<GenericItemViewHolder<*>> {
        val response = getFeedUseCase.invoke()
        if (response is Result.Success) {
            return response.data.map {
                when (it) {
                    is MovieModel -> {
                        MovieFeedViewHolder(
                            it
                        )
                    }
                    is StatusModel -> {
                        StatusFeedViewHolder(
                            it
                        )
                    }
                    else -> {
                        EmptyViewHolder(
                            it ?: "" //TODO: Handle nulls
                        )
                    }
                }

            }
        }
        return listOf()
    }
}