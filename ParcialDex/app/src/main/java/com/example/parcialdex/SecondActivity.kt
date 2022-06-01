package com.example.parcialdex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcialdex.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        * Here we get the data from the screen 1 and add them with the data from screen 2 in
        *  the Intent here.
        */

        val name = intent.getStringExtra("EXTRA_NAME")
        val type = intent.getStringExtra("EXTRA_TYPE")

        binding.btnNext2.setOnClickListener {

            val weight = binding.etWeight.text.toString().toDouble()
            val height = binding.etHeight.text.toString().toDouble()

            Intent(this, ThirdActivity::class.java).also {

                /*Adding both datas to screen 3*/

                val bundle = Bundle()
                with(bundle) {
                    putDouble("EXTRA_WEIGHT", weight)
                    putDouble("EXTRA_HEIGHT", height)
                    putString("EXTRA_NAME", name)
                    putString("EXTRA_TYPE", type)
                    it.putExtras(bundle)
                }
                startActivity(it)
            }
        }
    }
}