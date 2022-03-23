package com.nordsec.locationapp.locations.data

import com.nordsec.locationapp.common.LocationWithDistance
import io.reactivex.rxjava3.core.Single

interface LocationsDataSource {

    fun getLocationsByName(): Single<Locations>

    fun getLocationsByDistance(location: String): Single<List<LocationWithDistance>>

}