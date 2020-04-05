package com.mmicu.demo.utils

import android.util.Log


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