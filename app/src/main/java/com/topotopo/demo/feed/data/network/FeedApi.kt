package com.topotopo.demo.feed.data.network

import com.topotopo.demo.feed.data.model.GetFeedResponse
import retrofit2.http.GET

interface FeedApi {

    @GET("feed")
    suspend fun fetchFeed(): GetFeedResponse
}