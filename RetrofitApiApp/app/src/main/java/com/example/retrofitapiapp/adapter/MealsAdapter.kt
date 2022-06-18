package com.example.retrofitapiapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.retrofitapiapp.databinding.MealsRowBinding

class MealsAdapter : RecyclerView.Adapter<MealsAdapter.MyViewHolder>() {

    private var myListMeal: MutableList<Triple<String, String, Int>> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding = MealsRowBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(myListMeal[position])
    }

    override fun getItemCount(): Int {
        return myListMeal.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<Triple<String, String, Int>>) {
        myListMeal.clear()
        myListMeal.addAll(newList)
        notifyDataSetChanged()
    }


    class MyViewHolder(val itemBinding: MealsRowBinding) :

        RecyclerView.ViewHolder(itemBinding.root) {

        fun onBind(mealsInfo: Triple<String, String, Int>) {
            itemBinding.mealId.text = mealsInfo.first
            itemBinding.mealImage.load(mealsInfo.second)
            itemBinding.mealId.text = mealsInfo.third.toString()
        }
    }
}




