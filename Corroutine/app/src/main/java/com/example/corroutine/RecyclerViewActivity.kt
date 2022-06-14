package com.example.corroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.corroutine.adapter.Adapter
import com.example.corroutine.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var myAdapter: Adapter
    private lateinit var  viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        myAdapter = Adapter()

        setUpAdapterPlusRecycler()
        onObserve()
    }


    private fun setUpAdapterPlusRecycler(){
        binding.apply {
            recyclerViewActivity.apply {
                adapter = myAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

    private fun onObserve() {
        viewModel.getDataFromRepository()
        viewModel.game.observe(this, Observer {
            myAdapter.addNewGame(it)
        })
    }
}