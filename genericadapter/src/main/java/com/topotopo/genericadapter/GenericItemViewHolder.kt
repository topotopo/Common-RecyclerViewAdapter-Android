package com.topotopo.genericadapter


interface GenericItemViewHolder<T> {
    var data: T
    var layoutId: Int
}