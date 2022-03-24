package com.nordsec.locationapp.locations.domain

import com.nordsec.locationapp.locations.data.LocationWithDistance
import com.nordsec.locationapp.rx.Converter

class LocationsListByDistanceConverter : Converter<List<LocationWithDistance>, LocationsViewState> {
    override fun apply(location: List<LocationWithDistance>): LocationsViewState {
        var locationList = location.map { locationItem ->
            LocationDomainModel(
                cityName = locationItem.location.city
            )
        }
        return LocationsViewState.Success(locationList)
    }
}