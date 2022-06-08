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


    // Firebase configuration:::

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

        binding.btnGoogle.setOnClickListener {
            signIn()
        }




        binding.btnTwitter.setOnClickListener {
            loginTwitter()
        }

        //binding.btnRegister.setOnClickListener {
        //  Intent(this, RegisterActivity::class.java).also {
        //startActivity(it)
        // }
        //}
    }

    // Twitter auth process:::

    private fun loginTwitter() {

        //Twitter firebase:::

        val provider = OAuthProvider.newBuilder("twitter.com")

        val pendingResultTask = mAuth?.pendingAuthResult
        if (pendingResultTask != null) {
            // There's something already here! Finish the sign-in for your user.
            pendingResultTask
                .addOnSuccessListener(
                    OnSuccessListener {
                        // User is signed in.
                        // IdP data available in
                        // authResult.getAdditionalUserInfo().getProfile().
                        // The OAuth access token can also be retrieved:
                        // authResult.getCredential().getAccessToken().
                        // The OAuth secret can be retrieved by calling:
                        // authResult.getCredential().getSecret().
                    })
                .addOnFailureListener {
                    // Handle failure.
                }
        } else {
            mAuth
                ?.startActivityForSignInWithProvider( /* activity= */this, provider.build())
                ?.addOnSuccessListener {
                    // User is signed in.
                    // IdP data available in
                    // authResult.getAdditionalUserInfo().getProfile().
                    // The OAuth access token can also be retrieved:
                    // authResult.getCredential().getAccessToken().
                    // The OAuth secret can be retrieved by calling:
                    // authResult.getCredential().getSecret().
                }
                ?.addOnFailureListener {
                    // Handle failure.
                }
        }
    }







   /* private fun loginTwitter() {

        val provider = OAuthProvider.newBuilder("twitter.com")
        // Target specific email with login hint.
        provider.addCustomParameter("lang", "fr")

        val pendingResultTask = firebaseAuth?.pendingAuthResult

        if (pendingResultTask != null) {
            // There's something already here! Finish the sign-in for your user.
            pendingResultTask
                .addOnSuccessListener(
                    OnSuccessListener {
                        Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, FinalActivity::class.java))
                    })
                .addOnFailureListener {
                    Toast.makeText(this, "Something is not right", Toast.LENGTH_SHORT).show()

                }
        } else {
            firebaseAuth?.startActivityForSignInWithProvider(this, provider.build())?.addOnSuccessListener {
                    Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, FinalActivity::class.java))
                }?.addOnFailureListener {
                    Toast.makeText(this, "Something is not right", Toast.LENGTH_SHORT).show()
                }
        }
    }*/









































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
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
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
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(
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