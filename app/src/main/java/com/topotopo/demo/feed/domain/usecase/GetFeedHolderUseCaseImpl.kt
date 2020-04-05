package com.topotopo.demo.feed.domain.usecase

import com.topotopo.demo.BR
import com.topotopo.demo.feed.domain.model.MovieModel
import com.topotopo.demo.feed.domain.model.StatusModel
import com.topotopo.demo.feed.presentation.itemviewholder.Empty
import com.topotopo.demo.feed.presentation.itemviewholder.MovieFeedItemHolder
import com.topotopo.demo.feed.presentation.itemviewholder.StatusFeedItemHolder
import com.topotopo.demo.utils.Result
import com.topotopo.genericadapter.CommonItemHolder

class GetFeedHolderUseCaseImpl(private val getFeedUseCase: GetFeedUseCase) : GetFeedHolderUseCase {
    override suspend fun invoke(): List<CommonItemHolder<*>> {
        val response = getFeedUseCase.invoke()
        if (response is Result.Success) {
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
        return listOf()
    }
}