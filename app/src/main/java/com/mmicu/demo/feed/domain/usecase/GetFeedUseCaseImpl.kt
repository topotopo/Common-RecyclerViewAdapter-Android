package com.mmicu.demo.feed.domain.usecase

import com.mmicu.demo.feed.domain.model.FeedModel
import com.mmicu.demo.feed.domain.repository.FeedRepository
import com.mmicu.demo.utils.Result
import java.io.IOException

class GetFeedUseCaseImpl(private val feedRepository: FeedRepository) : GetFeedUseCase {

    override suspend fun invoke(): Result<List<FeedModel?>> {
        return feedRepository.fetchAllFeed() ?: Result.Error(IOException())
    }
}