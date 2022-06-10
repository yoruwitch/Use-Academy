package com.example.logindatastore

import android.content.Intent
import android.opengl.ETC1.isValid
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.logindatastore.databinding.ActivityLoginBinding
import kotlinx.coroutines.runBlocking

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.btnRegister.setOnClickListener {
            if (isValid()) {
                saveUser()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Fill all the blanks", Toast.LENGTH_SHORT).show()
            }

        }
    }


    // Instead of setting multiple read and set functions,
    // I created a single Any type read/set function
    // so here in this saveUser() I can link to the key for each required info from the user:::

    private fun saveUser() {
        runBlocking {
            DataStoreManager.apply {

                setDataStore(
                    preferencesKey = stringPreferencesKey("NAME"),
                    value = binding.nameRegister.text.toString()
                )
                setDataStore(
                    preferencesKey = intPreferencesKey("AGE"),
                    value = binding.ageRegister.text.toString().toInt()
                )
                setDataStore(
                    preferencesKey = stringPreferencesKey("CITY"),
                    value = binding.cityRegister.text.toString()
                )
                setDataStore(
                    preferencesKey = stringPreferencesKey("NICKNAME"),
                    value = binding.nicknameRegister.text.toString()
                )
                setDataStore(
                    preferencesKey = booleanPreferencesKey("HAS_LOGIN"), true
                )
            }
        }
    }


    // verifying if all data has been given by the user:::

    private fun isValid(): Boolean {
        return (
                binding.nameRegister.text.isNotEmpty() &&
                        binding.ageRegister.text.isNotEmpty() &&
                        binding.cityRegister.text.isNotEmpty() &&
                        binding.nicknameRegister.text.isNotEmpty()
                )
    }
}