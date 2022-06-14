package com.example.corroutine.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.corroutine.databinding.LayoutGameStringBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var listOfStrings = ArrayList<String>()

    class ViewHolder(val binding: LayoutGameStringBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(game: String) {
            binding.tvGame.text = game

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutGameStringBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listOfStrings[position])
    }

    override fun getItemCount(): Int {
        return listOfStrings.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addNewGame(game: String) {
        listOfStrings.add(listOfStrings.size, game)
        notifyDataSetChanged()
    }
}