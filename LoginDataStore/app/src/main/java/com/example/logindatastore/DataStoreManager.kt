package com.example.logindatastore

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.logindatastore.DataStoreManager.preferencesDataStore
import kotlinx.coroutines.flow.first

object DataStoreManager {

    private lateinit var application: Application

    fun initialize(application: Application) {
        this.application = application
    }

    private val Context.preferencesDataStore:
            DataStore<Preferences> by preferencesDataStore(name = "USER_INFO")

    // async functions that reads any type of data and set any type of data:::

    suspend fun <T : Any> setDataStore(
        preferencesKey: Preferences.Key<T>,
        value: T
    ) {
        application.preferencesDataStore.edit {
            it[preferencesKey] = value
        }
    }

    suspend fun <T : Any> readDataStore(
        preferencesKey: Preferences.Key<T>
    ): T? {
        return application.preferencesDataStore.data.first()[preferencesKey]
    }

}

/*
// saves username in a key "name"
suspend fun setUserNameDataStore(name: String) {
    DataStoreManager.application.preferencesDataStore.edit {
        it[stringPreferencesKey("NAME")] = name
    }
}


// saves user's age in a key "age"
suspend fun setAgeUserDataStore(age: Int) {
    DataStoreManager.application.preferencesDataStore.edit {
        it[intPreferencesKey("AGE")] = age

    }
}

suspend fun setCityUserDataStore(city: String) {
    DataStoreManager.application.preferencesDataStore.edit {
        it[stringPreferencesKey("CITY")] = city
    }
}

suspend fun setNickNameUserDataStore(nickname: String) {
    DataStoreManager.application.preferencesDataStore.edit {
        it[stringPreferencesKey("NICKNAME")] = nickname
    }
*/
//functions that read the data stored:::

/* suspend fun readUserNameDataStore(): String {
     return application.preferencesDataStore.data.first()[stringPreferencesKey("NAME")] ?: ""
 }

 suspend fun readUserAgeDataStore(): Int {
     return application.preferencesDataStore.data.first()[intPreferencesKey("AGE")] ?: 0
 }

 suspend fun readCityNameDataStore(): String {
     return application.preferencesDataStore.data.first()[stringPreferencesKey("CITY")] ?: ""
 }

 suspend fun readNickNameUserNameDataStore(): String {
     return application.preferencesDataStore.data.first()[stringPreferencesKey("NICKNAME")] ?: ""
 } */