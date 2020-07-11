package com.mmicu.demo.feed.data.repository

import com.mmicu.demo.feed.data.network.FeedApi
import com.mmicu.demo.feed.domain.model.FeedModel
import com.mmicu.demo.feed.domain.model.MovieModel
import com.mmicu.demo.feed.domain.model.StatusModel
import com.mmicu.demo.feed.domain.repository.FeedRepository
import com.mmicu.demo.feed.domain.repository.BaseRepository
import com.mmicu.demo.feed.data.response.Result
import com.mmicu.demo.feed.data.response.BaseResponse
import com.mmicu.demo.feed.domain.model.MusicModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FeedRepositoryImpl(private val feedApi: FeedApi) : FeedRepository, BaseRepository() {

    override suspend fun fetchAllFeed(): Result<List<FeedModel?>>? {
        return safeApiCall(call = {
            withContext(Dispatchers.IO) {
                val response = feedApi.fetchFeed()
                val newFeedList = response.feedList.map {
                    when (it.type) {
                        "movie" -> {
                            MovieModel(
                                id = it.id,
                                title = it.title,
                                description = it.description,
                                imageUrl = it.imageUrl
                            )
                        }
                        "status" -> {
                            StatusModel(
                                id = it.id,
                                title = it.title,
                                content = it.description
                            )
                        }
                        "music" -> {
                            MusicModel(
                                id = it.id,
                                title = it.title,
                                artist = it.artist,
                                description = it.description,
                                imageUrl = it.imageUrl
                            )
                        }
                        else -> {
                            null
                        }
                    }
                }
                BaseResponse(
                    status = "Success",
                    data = newFeedList,
                    message = ""
                )
            }
        })
    }
}