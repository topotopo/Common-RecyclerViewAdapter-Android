package com.mmicu.demo.feed.data.network

import com.mmicu.demo.feed.data.response.GetFeedResponse
import retrofit2.http.GET

interface FeedApi {

    @GET("feed")
    suspend fun fetchFeed(): GetFeedResponse
}