package com.topotopo.demo.feed.domain.usecase

import com.topotopo.genericadapter.CommonItem

interface GetFeedHolderUseCase {
    suspend fun invoke(): List<CommonItem<*>>
}