package com.topotopo.genericadapterdemo.model

data class MovieModel(
    val id: String,
    val title: String,
    val imageUrl: String,
    val description: String
)

data class StatusModel(
    val id: String,
    val title: String,
    val content: String
)