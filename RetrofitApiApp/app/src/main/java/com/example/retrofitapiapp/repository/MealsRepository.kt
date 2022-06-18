package com.example.retrofitapiapp.repository

import com.example.retrofitapiapp.api.MealResponse
import com.example.retrofitapiapp.api.SingletonApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException


class MealsRepository {

    private var endpointsApi = SingletonApi("https://www.themealdb.com/").create()

    suspend fun getAllMeals(
        category: String
    ): Flow<MealResponse> {
        return flow {
            endpointsApi.getMeals(
                category
            ).let { response ->
                if (response.isSuccessful) {
                    response.body()        // gets the json body
                } else {
                    throw HttpException(response)
                }
            }?.let {
                emit(it)
            }
        }
    }
}