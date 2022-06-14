package com.example.loginfirebase.view.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginfirebase.databinding.ActivitySignInBinding
import com.example.loginfirebase.view.mainscreen.MainScreenActivity
import com.example.loginfirebase.view.register.Register
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        auth = Firebase.auth

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { it ->

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()


            // validation:::

            if (email.isEmpty() || password.isEmpty()) {

                val snackbar = Snackbar.make(it, "Fields need to be filled", Snackbar.LENGTH_LONG)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this@SignInActivity) { task ->
                    if (task.isSuccessful) {
                        intentToMainScreen()
                    }
                    // messages for possible errors:::
                }.addOnFailureListener(this@SignInActivity) {
                    Toast.makeText(this@SignInActivity, "Error", Toast.LENGTH_LONG).show()
                }
        }
        // for new users/sign up/register:::

        binding.btnRegisterNow.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }
    }

    // for successful login in, the user is directed to the MainScreen Activity:::

    private fun intentToMainScreen() {
        val intent = Intent(this, MainScreenActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = FirebaseAuth.getInstance().currentUser

        if (currentUser != null) {
            intentToMainScreen()
        }
    }
}