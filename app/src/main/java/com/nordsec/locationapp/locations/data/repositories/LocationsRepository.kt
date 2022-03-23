package com.nordsec.locationapp.locations.data.repositories

import com.nordsec.locationapp.locations.data.LocationDataSourceImpl
import com.nordsec.locationapp.locations.domain.LocationsListByDistanceConverter
import com.nordsec.locationapp.locations.domain.LocationsListConverter
import com.nordsec.locationapp.locations.domain.LocationsViewState
import com.nordsec.locationapp.rx.SchedulingStrategyFactory
import io.reactivex.rxjava3.core.Observable


/*
* The class Location repository to read location data and return parsed data
*
* The function getLocationsSortedByDistance should return list of location sorted
* by set custom location (user can choose any location)
*
* The function getLocationsSortedByDistance should rerun list of location sorted by city name
*
*/
class LocationsRepository constructor(
    private val locationsDataSource: LocationDataSourceImpl,
    private val locationsListConverter: LocationsListConverter,
    private val locationsListByDistanceConverter: LocationsListByDistanceConverter,
    private val schedulingStrategyFactory: SchedulingStrategyFactory
) {

    fun getLocationsSortedByCityName(): Observable<LocationsViewState> {
        val locationDataSourceObservable =
            locationsDataSource.getLocationsByName().toObservable()

        return locationDataSourceObservable
            .map(locationsListConverter)
            .startWithItem(LocationsViewState.Loading)
            .compose(schedulingStrategyFactory.create())
    }

       fun getLocationsSortedByDistance(location: String): Observable<LocationsViewState> {
           val locationDataSourceObservable =
               locationsDataSource.getLocationsByDistance(location).toObservable()

           return locationDataSourceObservable
               .map(locationsListByDistanceConverter)
               .startWithItem(LocationsViewState.Loading)
               .compose(schedulingStrategyFactory.create())

       }

}