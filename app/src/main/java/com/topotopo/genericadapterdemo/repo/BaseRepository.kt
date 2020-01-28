package com.topotopo.genericadapterdemo.repo

import android.util.Log
import com.topotopo.genericadapterdemo.service.CallState
import com.topotopo.genericadapterdemo.service.CommonResponse


open class BaseRepository {

    suspend fun <T : Any> safeApiCall(
        call: suspend () -> CommonResponse<T>
    ): CallState<T>? {
        return try {
            val response = call.invoke()
            if (response.status == "Success") {
                CallState.Success(response.data)
            } else {
                CallState.Error(java.lang.Exception(response.message))
            }
        } catch (e: Exception) {
            Log.e("NetworkCall", "$e")
            CallState.Error(e)
        }
    }
}