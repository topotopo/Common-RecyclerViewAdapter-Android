package com.topotopo.genericadapterdemo.service.mock

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.topotopo.genericadapterdemo.model.MovieModel
import com.topotopo.genericadapterdemo.service.CommonResponse
import com.topotopo.genericadapterdemo.service.FeedApi
import retrofit2.http.GET
import retrofit2.mock.BehaviorDelegate

class FakeFeedApi(
    private val delegate: BehaviorDelegate<FeedApi>,
    private val context: Context
) : FeedApi {

    @GET("")
    override suspend fun fetchFeed(): CommonResponse<List<MovieModel>> {
        val jsonString = FakeJsonFileReader().readMockJson(context)
        val userListType = object : TypeToken<List<MovieModel>>() {

        }.type

        val userArray: List<MovieModel> = Gson().fromJson(jsonString, userListType)
        return delegate.returningResponse(userArray).fetchFeed()
    }
}