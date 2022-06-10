package com.example.logindatastore

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.logindatastore.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        show()
    }

    // As in saveUser() in the LoginActivity, here I'm using the generic function to give they
    // needed keys as well as the null treatment

    private fun show() {
        val name: String
        val age: Int
        val city: String
        val nickname: String

        runBlocking {
            name = DataStoreManager.readDataStore(stringPreferencesKey("NAME"))?:""
            age = DataStoreManager.readDataStore(intPreferencesKey("AGE"))?:0
            city = DataStoreManager.readDataStore(stringPreferencesKey("CITY"))?:""
            nickname = DataStoreManager.readDataStore(stringPreferencesKey("NICKNAME"))?:""
        }
        Toast.makeText(
            this, "Name: $name, age: $age, city: $city, nickname: $nickname",
            Toast.LENGTH_SHORT
        ).show()
    }
}