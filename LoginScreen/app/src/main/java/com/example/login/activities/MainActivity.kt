package com.example.login.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.R
import com.example.login.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.OAuthProvider


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    // Google + Firebase configuration:::

    private var mGoogleSignInClient: GoogleSignInClient? = null
    private val mSignIn = 666
    private var mAuth: FirebaseAuth? = null

    private lateinit var token: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Pão de Mel da Vick"

        mAuth = FirebaseAuth.getInstance()

        createRequest()

       // Buttons to log-in

        binding.btnGoogle.setOnClickListener {
            signIn()
        }

        binding.btnTwitter.setOnClickListener {
            val intent = Intent(this@MainActivity, TwitterAuthActivity::class.java)
            startActivity(intent)
        }

    }

        // Configs for Google Sign in:::

        private fun createRequest() {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()


            mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        }

        private fun signIn() {
            val signIntent = mGoogleSignInClient!!.signInIntent
            startActivityForResult(signIntent, mSignIn)
        }

        // Validator and exception's treatment

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
            if (requestCode == mSignIn) {
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                    if (account != null) {
                        firebaseAuthWithGoogle(account) // function is written after this one
                    }
                } catch (e: ApiException) {
                    // Google Sign In failed, update UI appropriately
                    Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Here is where the real firebase interacts with the login itself:::

        private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
            val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
            mAuth?.signInWithCredential(credential)
                ?.addOnCompleteListener(
                    this
                ) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = mAuth!!.currentUser
                        val intent = Intent(applicationContext, FinalActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Sorry auth failed.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
        }
    }
