package com.example.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityFinalBinding

class FinalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Success!"

        /*Data from the login screen*/
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val password = intent.getStringExtra("EXTRA_PASSWORD")
        val loginCompleted =
            "Your email $email and your password $password has been successfully logged in. Welcome!"
        binding.result.text = loginCompleted


        /*Data from the register screen*/

        val extras = intent.extras
        val incomingName = extras?.getString("EXTRA_NAME_REG")
        val incomingCity = extras?.getString("EXTRA_PASSWORD_REG")
        val incomingPassword = extras?.getString("EXTRA_COUNTRY_REG")
        val incomingCountry = extras?.getString("EXTRA_CITY_REG")
        val incomingEmail = extras?.getString("EXTRA_EMAIL_REG")

        if (
            incomingName == null &&
            incomingCity == null &&
            incomingPassword == null &&
            incomingCountry == null &&
            incomingEmail == null
        ) {
            binding.result2.visibility = View.GONE
        } else {
            val loginRegistered =
                "Your email: $incomingEmail, password: $incomingPassword, city: $incomingCity," +
                        " country: $incomingCountry and name: $incomingName has been successfully registered!"
            binding.result2.text = loginRegistered
            binding.result.visibility = View.GONE
        }
    }
}