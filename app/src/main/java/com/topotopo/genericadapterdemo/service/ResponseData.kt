package com.topotopo.genericadapterdemo.service

import java.lang.Exception

sealed class CallState<out T : Any> {
    object Loading : CallState<Nothing>()
    data class Success<out T : Any>(val data: T) : CallState<T>()
    data class Error(val exception: Exception) : CallState<Nothing>()
}

data class CommonResponse<out T : Any>(
    val status: String,
    val data: T,
    val message: String
)