package com.topotopo.demo.feed.domain.usecase

import com.topotopo.genericadapter.GenericItemViewHolder

interface GetFeedHolderUseCase {
    suspend fun invoke(): List<GenericItemViewHolder<*>>
}