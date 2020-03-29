package com.topotopo.demo.feed.domain.usecase

import com.topotopo.demo.feed.domain.model.FeedModel
import com.topotopo.demo.utils.Result

interface GetFeedUseCase {

    suspend fun invoke(): Result<List<FeedModel?>>
}