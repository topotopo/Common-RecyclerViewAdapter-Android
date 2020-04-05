package com.topotopo.demo.feed.presentation.itemviewholder

import com.topotopo.demo.BR
import com.topotopo.genericadapter.CommonItemHolder

class Empty(override var data: Any?,
            override var layoutId: Int = -1,
            override var variableId: Int = BR.data) :
    CommonItemHolder<Any>