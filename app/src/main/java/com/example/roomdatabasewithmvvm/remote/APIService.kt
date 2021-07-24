package com.example.roomdatabasewithmvvm.remote

import com.example.roomdatabasewithmvvm.models.ResponseEntity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService {

    @Headers("Accept: application/json")
    @GET("b/60fa8fefa917050205ce5470")
    suspend fun getEntity(
        @Header("Content-Type") contentType: String,
    ): List<ResponseEntity>

}