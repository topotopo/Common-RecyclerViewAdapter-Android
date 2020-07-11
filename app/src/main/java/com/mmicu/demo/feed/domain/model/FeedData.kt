package com.mmicu.demo.feed.domain.model

import android.content.SyncRequest

data class MovieModel(
    val id: String,
    val title: String,
    val imageUrl: String,
    val description: String
) : FeedModel

data class StatusModel(
    val id: String,
    val title: String,
    val content: String
) : FeedModel

data class MusicModel(
    val id: String,
    val title: String,
    val artist: String,
    val description: String,
    var imageUrl: String
) : FeedModel

interface FeedModel