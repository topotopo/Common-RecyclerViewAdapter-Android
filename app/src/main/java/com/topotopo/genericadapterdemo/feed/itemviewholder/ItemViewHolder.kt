package com.topotopo.genericadapterdemo.feed.itemviewholder

import com.topotopo.genericadapter.GenericItemViewHolder
import com.topotopo.genericadapterdemo.R
import com.topotopo.genericadapterdemo.model.MovieModel
import com.topotopo.genericadapterdemo.model.StatusModel

class MovieFeedViewHolder(override var data: MovieModel,
                          override var layoutId: Int = R.layout.item_feed_movie) :
    GenericItemViewHolder<MovieModel>

class StatusFeedViewHolder(override var data: StatusModel,
                           override var layoutId: Int = R.layout.item_feed_status) :
    GenericItemViewHolder<StatusModel>