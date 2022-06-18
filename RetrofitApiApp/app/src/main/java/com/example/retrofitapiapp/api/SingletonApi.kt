package com.example.retrofitapiapp.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SingletonApi(private val baseUrl: String) {

    fun create(): EndpointsApi {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().build()
            )
            .build()
            .create(EndpointsApi::class.java)
    }
}