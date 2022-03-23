package com.nordsec.locationapp.locations.data.repositories

import com.nordsec.locationapp.locations.data.LocationDataSourceImpl
import com.nordsec.locationapp.locations.data.Locations
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
    private lateinit var locationsViewState: LocationsViewState

    @Mock
    private lateinit var locations: Locations

    private lateinit var repository: LocationsRepository

    @Before
    fun setUp() {
        repository = LocationsRepository(
            locationDataSourceImpl,
            locationsListConverter,
            TestSchedulingStrategyFactory.immediate())
    }

    @Test
    fun `should return correct movie view state when getLocationsSortedByCityName API is called`() {
        Mockito.`when`(locationDataSourceImpl.getLocationsByName()).thenReturn(
            Single.just(locations))
        Mockito.`when`(locationsListConverter.apply(locations)).thenReturn(locationsViewState)
        val observer = repository.getLocationsSortedByCityName().test()
        observer.assertValues(LocationsViewState.Loading, locationsViewState)
    }

}