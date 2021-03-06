package com.nordsec.locationapp.locations.data


import com.nordsec.locationapp.common.Utils
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LocationDataSourceImplTest {

    @Mock
    private lateinit var utils: Utils
    @Mock
    private lateinit var locations: Locations

    private lateinit var locationDataSourceImpl: LocationDataSourceImpl

    @Before
    fun setUp() {
        Mockito.`when`(utils.getLocationsList()).thenReturn(locations)
        locationDataSourceImpl = LocationDataSourceImpl(utils)
    }

    @Test
    fun `should load location list data from utils`() {
        val testObserver = locationDataSourceImpl.getLocationsByName().test()
        testObserver.assertComplete()
        testObserver.assertValueCount(1)
    }

    @Test
    fun `should load location list data from utils getLocationsByDistance is called`() {
        val testObserver = locationDataSourceImpl.getLocationsByDistance("").test()
        testObserver.assertComplete()
        testObserver.assertValueCount(1)
    }

}