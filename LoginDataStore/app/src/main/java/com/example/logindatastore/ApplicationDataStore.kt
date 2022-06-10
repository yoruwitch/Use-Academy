package com.example.logindatastore

import android.app.Application

class ApplicationDataStore : Application() {

    override fun onCreate() {
        super.onCreate()

        // initializing the DataStore with global context from the app
        DataStoreManager.initialize(this)
    }
}