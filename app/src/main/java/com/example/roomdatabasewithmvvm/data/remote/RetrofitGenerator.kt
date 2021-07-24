package com.example.roomdatabasewithmvvm.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGenerator {

    companion object {
        private val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build()
        }
    }

}