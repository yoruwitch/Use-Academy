package com.example.login.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityFinalBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.oAuthCredential
import com.google.firebase.ktx.Firebase

class FinalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Success!"

        // Similar process to putExtra or Bundle, instead using Firebase:::

        val name = binding.name
        val email = binding.email

        val account = GoogleSignIn.getLastSignedInAccount(this)


        //Twitter stuff:::

        //oAuthCredential().


        // Binding the data from the Login with the Authenticator:::

        if (account != null) {
            name.text = account.displayName
            email.text = account.email

            //Logout:::

            binding.btnLogout.setOnClickListener {

                FirebaseAuth.getInstance().signOut()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }


    }
}