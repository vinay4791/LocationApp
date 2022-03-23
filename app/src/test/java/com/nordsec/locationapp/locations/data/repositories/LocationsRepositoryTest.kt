package com.nordsec.locationapp.locations.data.repositories

import com.nordsec.locationapp.common.LocationWithDistance
import com.nordsec.locationapp.locations.data.LocationDataSourceImpl
import com.nordsec.locationapp.locations.data.Locations
import com.nordsec.locationapp.locations.domain.LocationsListByDistanceConverter
import com.nordsec.locationapp.locations.domain.LocationsListConverter
import com.nordsec.locationapp.locations.domain.LocationsViewState
import com.nordsec.locationapp.rx.TestSchedulingStrategyFactory
import io.reactivex.rxjava3.core.Single

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LocationsRepositoryTest {

    @Mock
    private lateinit var locationDataSourceImpl: LocationDataSourceImpl

    @Mock
    private lateinit var locationsListConverter: LocationsListConverter

    @Mock
    private lateinit var locationsListByDistanceConverter: LocationsListByDistanceConverter

    @Mock
    private lateinit var locationsViewState: LocationsViewState

    @Mock
    private lateinit var locations: Locations

    @Mock
    private lateinit var locationsWithDistance: List<LocationWithDistance>

    private lateinit var repository: LocationsRepository

    @Before
    fun setUp() {
        repository = LocationsRepository(
            locationDataSourceImpl,
            locationsListConverter,
            locationsListByDistanceConverter,
            TestSchedulingStrategyFactory.immediate())
    }

    @Test
    fun `should return correct movie view state when getLocationsByName API is called`() {
        Mockito.`when`(locationDataSourceImpl.getLocationsByName()).thenReturn(
            Single.just(locations))
        Mockito.`when`(locationsListConverter.apply(locations)).thenReturn(locationsViewState)
        val observer = repository.getLocationsSortedByCityName().test()
        observer.assertValues(LocationsViewState.Loading, locationsViewState)
    }

    @Test
    fun `should return correct movie view state when getLocationsSortedByCityName API is called`() {
        Mockito.`when`(locationDataSourceImpl.getLocationsByDistance("")).thenReturn(
            Single.just(locationsWithDistance))
        Mockito.`when`(locationsListByDistanceConverter.apply(locationsWithDistance)).
        thenReturn(locationsViewState)
        val observer = repository.getLocationsSortedByDistance("").test()
        observer.assertValues(LocationsViewState.Loading, locationsViewState)
    }

}