package com.nordsec.locationapp.locations.data

import com.nordsec.locationapp.common.Utils
import io.reactivex.rxjava3.core.Single


class LocationDataSourceImpl constructor(private val utils: Utils) : LocationsDataSource {

    override fun getLocations(): Single<Locations> {
       return Single.just(utils.getLocationsList())
    }
}