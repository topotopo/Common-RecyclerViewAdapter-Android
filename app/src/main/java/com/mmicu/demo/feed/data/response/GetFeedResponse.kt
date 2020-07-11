package com.mmicu.demo.feed.data.response

import com.google.gson.annotations.SerializedName

data class GetFeedResponse(@SerializedName("feed") val feedList: List<Feed>)

data class Feed(
    val id: String,
    val title: String,
    val description: String,
    val type: String,
    val imageUrl: String,
    val artist: String
)