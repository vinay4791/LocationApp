package com.nordsec.locationapp.locations.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.nordsec.locationapp.R
import com.nordsec.locationapp.locations.ui.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_LocationApp)
        setContentView(R.layout.activity_main)
    }
}