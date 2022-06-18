package com.example.retrofitapiapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.retrofitapiapp.adapter.MealsAdapter
import com.example.retrofitapiapp.databinding.ActivityMealsBinding
import com.example.retrofitapiapp.databinding.MealsRowBinding
import com.example.retrofitapiapp.viewmodel.MealsViewModel

class MealsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealsBinding
    private lateinit var viewModel: MealsViewModel
    private lateinit var adapterRecyclerView: MealsAdapter
    private lateinit var bindingOne: MealsRowBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewModel:::

        viewModel = ViewModelProvider(this).get(MealsViewModel::class.java)
        viewModel.getMeals("Beef")


        // starting recycler view:::
        startAdapter()
//        setDataAdapter()


        // testing:
//        viewModel.mealsResponse.observe(this) {
//            adapterRecyclerView.setData(List<Triple<String.String, Int>>()()())
//        }

    }

    private fun startAdapter() {
        binding.recyclerView.apply {
            adapterRecyclerView = MealsAdapter()
            layoutManager = LinearLayoutManager(context)
            adapter = adapterRecyclerView
        }
    }

//    private fun setDataAdapter() {
//        adapterRecyclerView.setData()
//    }


    // TODO: Implement the observer with the RecyclerView

    private fun onObserver() {
        viewModel.apply {
            mealsResponse.observe(this@MealsActivity, Observer { mealsResponse ->
                bindingOne.mealId.text = mealsResponse.meals[0].toString()
                bindingOne.mealName.text = mealsResponse.meals[0].toString()
                bindingOne.mealImage.load(mealsResponse.meals[0].idMeal)
            })
        }
    }



    // testing a solution

//    private fun myListUrls(): List<Triple<String, String, String>> = listOf(
//        Triple(
//            "https://picsum.photos/id/${rand(0, 100)}/200/300",
//            names[rand(0, 10)],
//            "(XX)-XXXX-XXXX"
//        ),
//        itemBinding.mealId.text = mealsInfo.first
//                itemBinding.mealImage.load(mealsInfo.second)
//                itemBinding.mealId.text = mealsInfo.third.toString()
}