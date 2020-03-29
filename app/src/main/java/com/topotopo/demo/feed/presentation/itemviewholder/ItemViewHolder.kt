package com.topotopo.demo.feed.presentation.itemviewholder

import com.topotopo.genericadapter.GenericItemViewHolder
import com.topotopo.demo.R
import com.topotopo.demo.feed.domain.model.MovieModel
import com.topotopo.demo.feed.domain.model.StatusModel

class MovieFeedViewHolder(override var data: MovieModel,
                          override var layoutId: Int = R.layout.item_feed_movie) :
    GenericItemViewHolder<MovieModel>

class StatusFeedViewHolder(override var data: StatusModel,
                           override var layoutId: Int = R.layout.item_feed_status) :
    GenericItemViewHolder<StatusModel>