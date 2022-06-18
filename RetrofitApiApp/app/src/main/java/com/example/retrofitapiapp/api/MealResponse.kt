package com.example.retrofitapiapp.api

import com.google.gson.annotations.SerializedName

data class MealResponse(

    @SerializedName("meals")
    val meals: List<Meal>

)

data class Meal(
    @SerializedName("srtMeal")
    val mealName: String,
    @SerializedName("strMealThumb")
    val mealImage: String,
    @SerializedName("idMeal")
    val idMeal: Int
)


//"meals": [
//    {
//      "strMeal": "Baked salmon with fennel & tomatoes",
//      "strMealThumb": "https://www.themealdb.com/images/media/meals/1548772327.jpg",
//      "idMeal": "52959"
//    },