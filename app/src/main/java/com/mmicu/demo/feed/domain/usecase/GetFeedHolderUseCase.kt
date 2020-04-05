package com.mmicu.demo.feed.domain.usecase

import com.mmicu.commonadapter.CommonItemHolder

interface GetFeedHolderUseCase {
    suspend fun invoke(): List<CommonItemHolder<*>>
}