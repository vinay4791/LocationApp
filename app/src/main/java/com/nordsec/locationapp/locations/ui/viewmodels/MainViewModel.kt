package com.nordsec.locationapp.locations.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nordsec.locationapp.locations.data.repositories.LocationsRepository
import com.nordsec.locationapp.locations.domain.LocationsViewState
import io.reactivex.rxjava3.disposables.CompositeDisposable

/*
*
* MainViewModel to fetch repository data and display for view
*
*/
class MainViewModel constructor(private val repository: LocationsRepository) : ViewModel() {

    private val disposable = CompositeDisposable()
    private var _locationListData = MutableLiveData<LocationsViewState>()
    val locationListData: LiveData<LocationsViewState> = _locationListData

    fun getLocationsSortedByCityName() {
        disposable.add(
            repository.getLocationsSortedByCityName()
                .subscribe({ response ->
                    _locationListData.postValue(response)
                },
                    { error ->

                    })
        )

    }

    fun getLocationsSortedByDistance(location: String) {
        disposable.add(
            repository.getLocationsSortedByDistance(location)
                .subscribe({ response ->
                    _locationListData.postValue(response)
                },
                    { error ->

                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }





}