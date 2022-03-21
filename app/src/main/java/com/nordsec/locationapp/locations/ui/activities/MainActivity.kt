package com.nordsec.locationapp.locations.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nordsec.locationapp.R
import com.nordsec.locationapp.databinding.ActivityMainBinding
import com.nordsec.locationapp.locations.domain.LocationsViewState
import com.nordsec.locationapp.locations.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val detailViewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_LocationApp)
        setContentView(R.layout.activity_main)

        initialise()
    }

    private fun initialise(){
        observeLocationsListData()
        detailViewModel.getLocationsSortedByCityName()
    }

    private fun observeLocationsListData() {
        detailViewModel.locationListData.observe(this) {
            when (it) {
                is LocationsViewState.Loading -> {
                    Log.d("vinay","loading")
                }
                is LocationsViewState.Success -> {
                    Log.d("vinay",it.locations.toString())
                }
            }
        }
    }

}