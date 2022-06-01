package com.example.parcialdex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcialdex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val name = binding.etName.text.toString()
            val type = binding.etType.text.toString()

            Intent(this, SecondActivity::class.java).also {

                /*Data is going to be added in the screen 2*/

                it.putExtra("EXTRA_NAME", name)
                it.putExtra("EXTRA_TYPE", type)
                startActivity(it)
            }
        }
    }
}