package com.topotopo.demo.utils

import android.content.Context
import com.topotopo.demo.R
import java.io.InputStream
import java.util.*

class FakeJsonFileReader {

    fun readMockJson(context: Context): String {
        val stream: InputStream? = context.resources.openRawResource(R.raw.fetch_feed_response)
        return streamToString(stream!!)
    }

    private fun streamToString(stream: InputStream): String {
        var s: Scanner? = null
        try {
            s = Scanner(stream)
            s.useDelimiter("\\Z")
            return if (s.hasNext()) s.next() else ""
        } finally {
            s?.close()
        }
    }
}