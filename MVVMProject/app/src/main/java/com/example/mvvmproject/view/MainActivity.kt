package com.example.mvvmproject.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject.databinding.ActivityMainBinding
import com.example.mvvmproject.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setObservers()
        setUpListeners()
    }

    // This is the result printed in the screen using the observe to getl the result from the function
    // in the ViewModel

    private fun setObservers() {
        viewModel.apply {
            costs.observe(this@MainActivity) { result ->
                binding.result.text = "Your travel will cost: R$" + result.toString()
            }
        }
    }

    // Here this function is going to bind the function in the ViewModel to the EditTexts in the layout

    private fun setUpListeners() {
        binding.calculate.setOnClickListener {
            viewModel.calculateTotalCosts(
                distance = binding.distance.text.toString().toDouble(),
                gasOrAlcohol = binding.gasOrAlcohol.text.toString(),
                gasPrice = binding.gasOrAlcoholPrice.text.toString().toDouble(),
                kmPerLitres = binding.kmPerLitre.text.toString().toDouble(),
                alcoholPrice = binding.gasOrAlcoholPrice.text.toString().toDouble(),

                )
        }
    }
}