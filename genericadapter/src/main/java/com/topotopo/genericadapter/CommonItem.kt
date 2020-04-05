package com.topotopo.genericadapter


interface CommonItem<T> {
    var data: T?
    var layoutId: Int
    var variableId: Int
}