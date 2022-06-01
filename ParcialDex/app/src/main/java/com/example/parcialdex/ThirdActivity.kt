package com.example.parcialdex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcialdex.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Data got stored in the vals bellow*/

        val extras = intent.extras
        val incomingHeight = extras?.getDouble("EXTRA_HEIGHT")
        val incomingWeight = extras?.getDouble("EXTRA_WEIGHT")
        val incomingName = extras?.getString("EXTRA_NAME")
        val incomingType = extras?.getString("EXTRA_TYPE")

        val pokemonString =
            "Your $incomingName ,type: $incomingType, has been added to our ParcialDex!"
        binding.result.text = pokemonString

        val pokemonString2 =
            "Their height is $incomingHeight m and their weight is $incomingWeight kg"
        binding.result2.text = pokemonString2
    }
}