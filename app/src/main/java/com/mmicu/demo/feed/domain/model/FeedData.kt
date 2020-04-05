package com.mmicu.demo.feed.domain.model

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

interface FeedModel