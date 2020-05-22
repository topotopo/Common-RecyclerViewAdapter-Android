package com.mmicu.demo.feed.domain.usecase

import com.mmicu.demo.feed.domain.model.FeedModel
import com.mmicu.demo.utils.Result

class GetFeedHolderUseCaseImpl(private val getFeedUseCase: GetFeedUseCase) : GetFeedHolderUseCase {
    override suspend fun invoke(): Result<List<FeedModel?>> {
        val response = getFeedUseCase.invoke()
        if (response is Result.Success) {
            return response
        }
        return response
    }
}