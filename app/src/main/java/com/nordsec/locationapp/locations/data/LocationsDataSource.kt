package com.nordsec.locationapp.locations.data

import io.reactivex.rxjava3.core.Single

interface LocationsDataSource {

    fun getLocations(): Single<Locations>

}