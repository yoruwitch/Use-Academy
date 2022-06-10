package com.example.contactlist.contactlist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.contactlist.databinding.LayoutRecyclerViewBinding

class AdapterImages : RecyclerView.Adapter<AdapterImages.ViewHolderImages>() {

    private var imageList: MutableList<Triple<String, String, String>> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderImages {
        val itemBinding = LayoutRecyclerViewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolderImages(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolderImages, position: Int) {
        holder.onBind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(imageListAux: List<Triple<String, String, String>>) {
        imageList.clear()
        imageList.addAll(imageListAux)
        notifyDataSetChanged()
    }

    // Class ViewHolder
    class ViewHolderImages(val layout: LayoutRecyclerViewBinding) :
        RecyclerView.ViewHolder(layout.root) {

        fun onBind(imageInfo: Triple<String, String, String>) {
            layout.tvLinkContact.text = imageInfo.first
            layout.tvNameContact.text = imageInfo.second
            layout.tvNumContact.text = imageInfo.third
            layout.imImage.load(imageInfo.first)
        }
    }
}