package com.nordsec.locationapp.locations.domain


sealed class LocationsViewState {

    object Loading : LocationsViewState()

    data class Success(val locations: List<LocationDomainModel>) : LocationsViewState()

}