package com.example.roomdatabasewithmvvm.data.remote

import com.example.roomdatabasewithmvvm.data.models.ResponseEntity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface APIService {

    @Headers("Accept: application/json")
    @GET("/shivarajp/2cbe00030c04472c9d8ad4b0ec112dbe/raw/c651391e428182f08d60d59e79073f3fcf79b858/nobroker")
    suspend fun getEntity(
        @Header("Content-Type") contentType: String,
    ): List<ResponseEntity>

}