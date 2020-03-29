package com.topotopo.demo.feed.data.repository

import com.topotopo.demo.feed.data.network.FeedApi
import com.topotopo.demo.feed.domain.model.FeedModel
import com.topotopo.demo.feed.domain.model.MovieModel
import com.topotopo.demo.feed.domain.model.StatusModel
import com.topotopo.demo.feed.domain.repository.FeedRepository
import com.topotopo.demo.utils.BaseRepository
import com.topotopo.demo.utils.Result
import com.topotopo.demo.utils.BaseResponse
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