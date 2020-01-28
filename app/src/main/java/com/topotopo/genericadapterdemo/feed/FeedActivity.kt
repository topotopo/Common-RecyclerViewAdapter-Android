package com.topotopo.genericadapterdemo.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.topotopo.genericadapterdemo.R
import com.topotopo.genericadapterdemo.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityFeedBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_feed
        )

        val feedFragment = FeedFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, feedFragment).commit()
    }
}
