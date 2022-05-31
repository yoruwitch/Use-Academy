package com.example.exerciseua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            supportFragmentManager.apply {
                val fragment = MyFragment()
                val transaction = beginTransaction()
                transaction.replace(android.R.id.content, fragment)
                transaction.commit()
            }
        }
    }
}