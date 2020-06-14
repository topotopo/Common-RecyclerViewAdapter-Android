package com.mmicu.demo.feed.presentation.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.mmicu.demo.R
import com.mmicu.demo.feed.domain.model.MovieModel
import com.mmicu.demo.feed.domain.model.StatusModel
import com.mmicu.commonadapter.CommonItemHolder
import kotlinx.android.synthetic.main.item_feed_movie.view.*

data class MovieFeedItemHolder(
    override var data: MovieModel?,
    override var layoutId: Int = R.layout.item_feed_movie,
    override var variableId: Int?
) :
    CommonItemHolder<MovieModel> {
    override fun onBindViewHolder(itemView: View) {
        super.onBindViewHolder(itemView)

        Glide
            .with(itemView)
            .load(data?.imageUrl)
            .centerCrop()
            .into(itemView.feedImage)
    }
}

data class StatusFeedItemHolder(
    override var data: StatusModel?,
    override var layoutId: Int = R.layout.item_feed_status,
    override var variableId: Int?
) :
    CommonItemHolder<StatusModel>