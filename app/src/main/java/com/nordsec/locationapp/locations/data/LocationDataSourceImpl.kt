package com.nordsec.locationapp.locations.data

import com.nordsec.locationapp.common.Utils
import io.reactivex.rxjava3.core.Single


class LocationDataSourceImpl constructor(private val utils: Utils) : LocationsDataSource {

    override fun getLocationsByName(): Single<Locations> {
       return Single.just(utils.getLocationsList())
    }

    override fun getLocationsByDistance(location: Location): Single<Locations> {
        return Single.just(utils.getLocationListSortedWithSelectedLocation(location))
        TODO("Not yet implemented")
    }
}