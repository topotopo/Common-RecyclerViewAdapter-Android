package com.mmicu.demo.feed.domain.usecase

import com.mmicu.demo.feed.domain.model.FeedModel
import com.mmicu.demo.utils.Result

interface GetFeedHolderUseCase {
    suspend fun invoke(): Result<List<FeedModel?>>
}