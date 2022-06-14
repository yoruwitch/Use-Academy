package com.example.corroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private var repository = AppRepository()

    private var _game = MutableLiveData<String> ()
    val game : LiveData<String> = _game

    fun getDataFromRepository() {
        viewModelScope.launch (Dispatchers.IO){
            repository.getData().collect {
                _game.postValue(it)
            }
        }
    }
}