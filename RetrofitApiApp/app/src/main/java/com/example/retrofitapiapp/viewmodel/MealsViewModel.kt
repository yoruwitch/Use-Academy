package com.example.retrofitapiapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapiapp.api.MealResponse
import com.example.retrofitapiapp.repository.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MealsViewModel : ViewModel() {

    // setting up the ViewModel:::

    private var mealsRepository = MealsRepository()

    private var _mealsResponse: MutableLiveData<MealResponse> = MutableLiveData()
    val mealsResponse: LiveData<MealResponse> = _mealsResponse

    private var _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    // using the coroutines to get the meals in a separated thread:::

    @OptIn(InternalCoroutinesApi::class)
    fun getMeals(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mealsRepository.getAllMeals(
                category
            ).catch { error ->
                _error.postValue(error.message)
            }.collect { _mealsResponse.postValue(it) }
        }
    }
}