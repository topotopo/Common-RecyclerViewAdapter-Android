package com.topotopo.genericadapterdemo.service

import com.topotopo.genericadapterdemo.model.MovieModel
import retrofit2.http.GET

interface FeedApi {

    @GET("feed")
    suspend fun fetchFeed(): CommonResponse<List<MovieModel>>
}