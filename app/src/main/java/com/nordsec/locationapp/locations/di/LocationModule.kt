package com.nordsec.locationapp.locations.di

import com.nordsec.locationapp.locations.data.LocationDataSourceImpl
import com.nordsec.locationapp.locations.domain.LocationsListConverter
import com.nordsec.locationapp.locations.data.repositories.LocationsRepository
import com.nordsec.locationapp.locations.domain.LocationsListByDistanceConverter
import com.nordsec.locationapp.locations.ui.adapter.LocationsAdapter
import com.nordsec.locationapp.rx.AndroidSchedulingStrategyFactory
import com.nordsec.locationapp.locations.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val locationListModule = module {

    factory {
        LocationsAdapter()
    }

    factory {
        LocationDataSourceImpl(get())
    }

    factory {
        LocationsListConverter()
    }

    factory {
        LocationsListByDistanceConverter()
    }

    factory {
        LocationsRepository(
            get(),
            get(),
            get(),
            AndroidSchedulingStrategyFactory.io()
        )
    }

    viewModel { MainViewModel(get()) }

}

