package com.topotopo.demo.core

import com.topotopo.genericadapter.GenericAdapter
import com.topotopo.genericadapter.GenericItemViewHolder

class AppAdapter(
    listCommon: MutableList<GenericItemViewHolder<*>>,
    variableId: Int
) : GenericAdapter(listCommon, variableId)