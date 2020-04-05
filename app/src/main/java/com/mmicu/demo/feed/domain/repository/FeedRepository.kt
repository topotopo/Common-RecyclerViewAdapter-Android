package com.mmicu.demo.feed.domain.repository

import com.mmicu.demo.feed.domain.model.FeedModel
import com.mmicu.demo.utils.Result

interface FeedRepository {

    suspend fun fetchAllFeed(): Result<List<FeedModel?>>?

}