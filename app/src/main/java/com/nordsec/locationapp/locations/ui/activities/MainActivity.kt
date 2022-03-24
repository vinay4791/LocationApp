package com.nordsec.locationapp.locations.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nordsec.locationapp.R
import com.nordsec.locationapp.databinding.ActivityMainBinding
import com.nordsec.locationapp.locations.domain.LocationDomainModel
import com.nordsec.locationapp.locations.domain.LocationsViewState
import com.nordsec.locationapp.locations.ui.adapter.LocationsAdapter
import com.nordsec.locationapp.locations.ui.viewmodels.MainViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

import android.view.MenuItem
import com.nordsec.locationapp.common.Constants.NEW_YORK_STRING

class MainActivity : AppCompatActivity() {

    private val detailViewModel: MainViewModel by viewModel()
    private val locationsAdapter: LocationsAdapter by inject()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_LocationApp)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialise()
    }

    private fun initialise(){
        observeLocationsListData()
        detailViewModel.getLocationsSortedByCityName()
        setUpLocationsRecyclerView()
    }

    private fun observeLocationsListData() {
        detailViewModel.locationListData.observe(this) {
            when (it) {
                is LocationsViewState.Loading -> {
                    showApiLoadingIndicator()
                }
                is LocationsViewState.Success -> {
                    populateManufacturers(it.locations)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_by_name -> {
                detailViewModel.getLocationsSortedByCityName()
            }
            R.id.action_by_distance -> {
                detailViewModel.getLocationsSortedByDistance(NEW_YORK_STRING)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpLocationsRecyclerView() {
        binding.locationsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = locationsAdapter
        }
        locationsAdapter.setListener(listener)
    }

    private fun populateManufacturers(locations: List<LocationDomainModel>) {
        hideApiLoadingIndicator()
        binding.locationsRecyclerView.visibility = View.VISIBLE
        locationsAdapter.setItems(locations)
    }

    private fun showApiLoadingIndicator() {
        binding.loadingView.showLoading(R.color.loader_bg_white_transparent)
    }

    private fun hideApiLoadingIndicator() {
        binding.loadingView.hideLoading()
    }

    private val listener = object : LocationsAdapter.Listener {
        override fun itemSelected(locationKey: String) {
            detailViewModel.getLocationsSortedByDistance(locationKey)
        }

    }

}