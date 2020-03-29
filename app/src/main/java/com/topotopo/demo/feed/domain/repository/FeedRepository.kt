package com.topotopo.demo.feed.domain.repository

import com.topotopo.demo.feed.domain.model.FeedModel
import com.topotopo.demo.utils.Result

interface FeedRepository {

    suspend fun fetchAllFeed(): Result<List<FeedModel?>>?

}