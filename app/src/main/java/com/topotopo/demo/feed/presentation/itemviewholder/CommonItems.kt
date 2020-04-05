package com.topotopo.demo.feed.presentation.itemviewholder

import com.topotopo.demo.R
import com.topotopo.demo.feed.domain.model.MovieModel
import com.topotopo.demo.feed.domain.model.StatusModel
import com.topotopo.genericadapter.CommonItem

data class MovieFeedItem(
    override var data: MovieModel?,
    override var layoutId: Int = R.layout.item_feed_movie,
    override var variableId: Int
) :
    CommonItem<MovieModel>

data class StatusFeedItem(
    override var data: StatusModel?,
    override var layoutId: Int = R.layout.item_feed_status,
    override var variableId: Int
) :
    CommonItem<StatusModel>