package com.example.loginfirebase.view.register

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginfirebase.R
import com.example.loginfirebase.databinding.ActivityRegisterBinding
import com.example.loginfirebase.view.mainscreen.MainScreenActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class Register : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private val auth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegister.setOnClickListener { it ->

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            // validation:::

            if (email.isEmpty() or password.isEmpty()) {
                val snackbar = Snackbar.make(it, "Fill all the fields!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this@Register, "Account created!", Toast.LENGTH_LONG)
                            .show()

                        // clean both EditText's fields:::

                        val intent = Intent(this@Register, MainScreenActivity::class.java)
                        startActivity(intent)
                    }


                }.addOnFailureListener { failures ->
                    val messageError : String = when(failures){
                        is FirebaseAuthWeakPasswordException -> "Insert a password with at least 6 characters!"
                        is FirebaseAuthInvalidCredentialsException -> "Insert a valid email!"
                        is FirebaseAuthUserCollisionException -> "This account has been registered already..."
                        else -> "Error in registering user"
                    }
                    Toast.makeText(this@Register, messageError, Toast.LENGTH_LONG).show()

                }
            }
        }
    }
}