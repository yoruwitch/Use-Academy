package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Pão de Mel da Vick"

        /*In the login screen, we have two buttons: A register and a login button.
        * Each one is linked to a different Activity */

        binding.btnLogin.setOnClickListener{

            Intent(this, LoginActivity::class.java).also{
                startActivity(it)
            }
        }
        binding.btnRegister.setOnClickListener{
            Intent(this, RegisterActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}