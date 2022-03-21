package com.nordsec.locationapp

import android.app.Application
import android.content.Context
import com.nordsec.locationapp.di.locationAppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        currentApplication = this

        startKoin {
            androidContext(this@App)
            modules(locationAppModules)
        }

    }

    companion object {
        private var currentApplication: Application? = null
        private val application: Application?
            get() = currentApplication
        val context: Context
            get() = application!!.applicationContext
    }
}