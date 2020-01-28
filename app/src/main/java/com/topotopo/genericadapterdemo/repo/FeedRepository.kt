package com.topotopo.genericadapterdemo.repo

interface FeedRepository {

    suspend fun fetchAllFeed(): List<Any>

}