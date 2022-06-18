package com.example.retrofitapiapp.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EndpointsApi {

    //https://www.themealdb.com/api/json/v1/1/filter.php?c=Beef

    @GET("api/json/v1/1/filter.php")
    suspend fun getMeals(
        @Query("c") category: String
    ): Response<MealResponse>
}