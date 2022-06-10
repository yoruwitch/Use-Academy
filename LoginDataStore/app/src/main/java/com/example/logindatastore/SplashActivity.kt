package com.example.logindatastore

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.booleanPreferencesKey
import com.example.logindatastore.databinding.ActivitySplashBinding
import kotlinx.coroutines.runBlocking


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            verifyUser()
            finish()
        }, 2000)
    }

    // function to verify if the user is logged in:::

    private fun verifyUser() {
        runBlocking {

            val hasLogin = DataStoreManager.readDataStore(booleanPreferencesKey("HAS_LOGIN")) ?: false
            if (!hasLogin) {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}