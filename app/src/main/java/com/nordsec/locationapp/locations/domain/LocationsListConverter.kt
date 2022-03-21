package com.nordsec.locationapp.locations.domain

import com.nordsec.locationapp.locations.data.Locations
import com.nordsec.locationapp.rx.Converter

class LocationsListConverter : Converter<Locations, LocationsViewState> {
    override fun apply(location: Locations?): LocationsViewState {
        val locationList = location?.location?.map { locationItem ->
            LocationDomainModel(
                cityName = locationItem.city
            )
        } ?: emptyList()

        val sortedLocationList = locationList.sortedBy { it.cityName }
        return LocationsViewState.Success(sortedLocationList)
    }
}