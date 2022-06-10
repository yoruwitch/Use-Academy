package com.example.contactlist.contactlist.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contactlist.R
import com.example.contactlist.contactlist.fragment.FirstFragment
import com.example.contactlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Using the support manager to replace the original layout from this activity with
        // fragment's layout

       supportFragmentManager.beginTransaction().replace(
           R.id.mockFragment, FirstFragment.getInstance(),"Identify").commit()

    }

}