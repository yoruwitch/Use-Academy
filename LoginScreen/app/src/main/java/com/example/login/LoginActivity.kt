package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Login"

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.btnConfirm.setOnClickListener {
            val email = binding.emailLogin.text.toString()
            val password = binding.passwordLogin.text.toString()

            if (validation()) {
                Intent(this, FinalActivity::class.java).also {
                    it.putExtra("EXTRA_EMAIL", email)
                    it.putExtra("EXTRA_PASSWORD", password)

                    startActivity(it)
                }
            } else {
                Toast.makeText(this, getString(R.string.validate), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validation(): Boolean {
        val isNotEmpty = (
                binding.emailLogin.text.toString().isNotEmpty() &&
                        binding.passwordLogin.text.toString().isNotEmpty())
        return isNotEmpty
    }
}