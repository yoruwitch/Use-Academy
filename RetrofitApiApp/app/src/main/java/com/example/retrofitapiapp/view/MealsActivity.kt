package com.example.retrofitapiapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapiapp.R
import com.example.retrofitapiapp.adapter.MealsAdapter
import com.example.retrofitapiapp.databinding.ActivityMealsBinding
import com.example.retrofitapiapp.viewmodel.MealsViewModel

class MealsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealsBinding
    private lateinit var viewModel: MealsViewModel
    private lateinit var adapterRecyclerView: MealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MealsViewModel::class.java)
        viewModel.getMeals("Beef")

        // starting recycler view:::
        startAdapter()
        setDataAdapter()

    }

    private fun startAdapter(){
        binding.recyclerView.apply {
            adapterRecyclerView = MealsAdapter()
            layoutManager = LinearLayoutManager(context)
            adapter = adapterRecyclerView
        }
    }

    private fun setDataAdapter(){
        adapterRecyclerView.setData()
    }
    private fun onObservers(){
        viewModel.apply {
            mealsResponse.observe(this@MealsActivity, Observer {
                binding.
            })
        }
    }
}