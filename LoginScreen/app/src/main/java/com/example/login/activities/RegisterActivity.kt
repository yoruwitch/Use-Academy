package com.example.login.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityRegisterBinding
import com.google.firebase.auth.OAuthProvider




class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Register"

        val provider = OAuthProvider.newBuilder("twitter.com")





    /*
        /*This action is triggered by the save button:*/

        binding.btnSaveRegister.setOnClickListener {

            val nameRegister = binding.nameRegister.text.toString()
            val passwordRegister = binding.passwordRegister.text.toString()
            val countryRegister = binding.countryRegister.text.toString()
            val cityRegister = binding.cityRegister.text.toString()
            val emailRegister = binding.emailRegister.text.toString()

            if (validation()) {
                Intent(this, FinalActivity::class.java).also {
                    val bundle = Bundle()
                    with(bundle) {
                        putString("EXTRA_NAME_REG", nameRegister)
                        putString("EXTRA_PASSWORD_REG", passwordRegister)
                        putString("EXTRA_COUNTRY_REG", countryRegister)
                        putString("EXTRA_CITY_REG", cityRegister)
                        putString("EXTRA_EMAIL_REG", emailRegister)
                        it.putExtras(bundle)
                    }
                    startActivity(it)
                }
            }
        }

        /*This action is triggered by the cancel button:*/

        binding.btnCancelRegister.setOnClickListener {
            Intent(this, MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }

    /*Function to validate data in case of null*/

    private fun validation(): Boolean {
        val isNotEmpty = (
                binding.nameRegister.text.toString().isNotEmpty() &&
                        binding.passwordRegister.text.toString().isNotEmpty() &&
                        binding.countryRegister.text.toString().isNotEmpty() &&
                        binding.cityRegister.text.toString().isNotEmpty() &&
                        binding.emailRegister.text.toString().isNotEmpty()
                )
        return isNotEmpty
    }*/
    }
}