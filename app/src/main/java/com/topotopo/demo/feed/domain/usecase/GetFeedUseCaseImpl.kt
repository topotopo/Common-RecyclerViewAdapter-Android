package com.topotopo.demo.feed.domain.usecase

import com.topotopo.demo.feed.domain.model.FeedModel
import com.topotopo.demo.feed.domain.repository.FeedRepository
import com.topotopo.demo.utils.Result
import java.io.IOException

class GetFeedUseCaseImpl(private val feedRepository: FeedRepository) : GetFeedUseCase {

    override suspend fun invoke(): Result<List<FeedModel?>> {
        return feedRepository.fetchAllFeed() ?: Result.Error(IOException())
    }
}