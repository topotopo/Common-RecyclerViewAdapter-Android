package com.mmicu.demo.feed.domain.usecase

import com.mmicu.demo.BR
import com.mmicu.demo.feed.domain.model.MovieModel
import com.mmicu.demo.feed.domain.model.StatusModel
import com.mmicu.demo.feed.presentation.viewholder.Empty
import com.mmicu.demo.feed.presentation.viewholder.MovieFeedItemHolder
import com.mmicu.demo.feed.presentation.viewholder.StatusFeedItemHolder
import com.mmicu.demo.feed.data.response.Result
import com.mmicu.commonadapter.CommonItemHolder
import com.mmicu.demo.feed.domain.model.MusicModel
import com.mmicu.demo.feed.presentation.viewholder.MusicItemHolder

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
                    is MusicModel -> {
                        MusicItemHolder(
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