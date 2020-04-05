package com.topotopo.demo.feed.domain.usecase

import com.topotopo.genericadapter.CommonItemHolder

interface GetFeedHolderUseCase {
    suspend fun invoke(): List<CommonItemHolder<*>>
}