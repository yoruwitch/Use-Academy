package com.example.mvvmproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

class MainViewModel : ViewModel() {

    private var totalCosts: Double = 0.0

    private val _costs: MutableLiveData<Double> = MutableLiveData()
    val costs: LiveData<Double>
        get() = _costs


    // function to calculate the total costs of the travel

    fun calculateTotalCosts(
        distance: Double,
        gasOrAlcohol: String,
        gasPrice: Double,
        alcoholPrice: Double,
        kmPerLitres: Double
    ) {

        if (gasOrAlcohol == "Gas") {
            val consume = distance * kmPerLitres
            val result = (gasPrice * consume)
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN
            val roundoff = df.format(result).toDouble()
            _costs.postValue(roundoff)
        } else {
            val consume = distance * kmPerLitres
            val result = alcoholPrice * consume
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN
            val roundoff = df.format(result).toDouble()
            _costs.postValue(roundoff)

        }
    }
}