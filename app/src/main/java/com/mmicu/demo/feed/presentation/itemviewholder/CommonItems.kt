package com.mmicu.demo.feed.presentation.itemviewholder

import com.mmicu.demo.R
import com.mmicu.demo.feed.domain.model.MovieModel
import com.mmicu.demo.feed.domain.model.StatusModel
import com.mmicu.commonadapter.CommonItemHolder

data class MovieFeedItemHolder(
    override var data: MovieModel?,
    override var layoutId: Int = R.layout.item_feed_movie,
    override var variableId: Int?
) :
    CommonItemHolder<MovieModel>

data class StatusFeedItemHolder(
    override var data: StatusModel?,
    override var layoutId: Int = R.layout.item_feed_status,
    override var variableId: Int?
) :
    CommonItemHolder<StatusModel>