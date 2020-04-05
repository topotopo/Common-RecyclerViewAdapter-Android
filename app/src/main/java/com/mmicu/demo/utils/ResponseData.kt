package com.mmicu.demo.utils

import java.lang.Exception

sealed class Result<out T : Any> {
    object Loading : Result<Nothing>()
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

data class BaseResponse<out T : Any>(
    val status: String,
    val data: T,
    val message: String
)