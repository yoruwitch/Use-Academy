package com.example.loginfirebase.view.mainscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginfirebase.databinding.ActivityMainScreenBinding
import com.example.loginfirebase.view.login.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Login from both Register and Login screens get here:::


        val email = binding.userEmail

        val acct = Firebase.auth.currentUser
        if (acct != null) {
            email.text = acct.email
        }

        // Logout button:::

        binding.btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}