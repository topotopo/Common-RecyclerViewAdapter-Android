package com.mmicu.demo.feed.domain.repository

import com.mmicu.demo.feed.domain.model.FeedModel
import com.mmicu.demo.feed.data.response.Result

interface FeedRepository {

    suspend fun fetchAllFeed(): Result<List<FeedModel?>>?

}