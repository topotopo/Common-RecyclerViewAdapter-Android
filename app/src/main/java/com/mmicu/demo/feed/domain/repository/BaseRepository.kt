package com.mmicu.demo.feed.domain.repository

import android.util.Log
import com.mmicu.demo.feed.data.response.BaseResponse
import com.mmicu.demo.feed.data.response.Result


open class BaseRepository {

    suspend fun <T : Any> safeApiCall(
        call: suspend () -> BaseResponse<T>
    ): Result<T>? {
        return try {
            val response = call.invoke()
            if (response.status == "Success") {
                Result.Success(response.data)
            } else {
                Result.Error(java.lang.Exception(response.message))
            }
        } catch (e: Exception) {
            Log.e("NetworkCall", "$e")
            Result.Error(e)
        }
    }
}