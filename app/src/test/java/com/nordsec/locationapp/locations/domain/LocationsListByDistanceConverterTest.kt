package com.nordsec.locationapp.locations.domain

import com.google.common.truth.Truth
import com.nordsec.locationapp.common.LocationWithDistance
import com.nordsec.locationapp.locations.data.Location
import org.junit.Before
import org.junit.Test

class LocationsListByDistanceConverterTest {

    private lateinit var locationsListByDistanceConverter:  LocationsListByDistanceConverter

    @Before
    fun setUp() {
        locationsListByDistanceConverter = LocationsListByDistanceConverter()
    }

    @Test
    fun `should convert list of location api response to locations viewstate`() {
        val convertedViewState = locationsListByDistanceConverter.apply(getMockLocationListResponse())
        val expected = LocationsViewState.Success(getSortedLocationDomainModels())
        Truth.assertThat(convertedViewState).isEqualTo(expected)
    }

    /**
     * Returns the mock location List response
     */

    private fun getMockLocationListResponse(): List<LocationWithDistance> {
        return listOf(

            LocationWithDistance(
                location = Location(
                    city = "New York",
                    latitude = 40.712784F,
                    longitude = -74.00594F
                ),0.0
            ),
            LocationWithDistance(
                location = Location(
                    city = "Los Angeles",
                    latitude = 34.052235F,
                    longitude = -118.24368F
                ),0.0
            ),
            LocationWithDistance(
                location = Location(
                    city = "Chicago",
                    latitude = 41.878113F,
                    longitude = -87.6298F
                ),0.0
            )


        )
    }

    private fun getSortedLocationDomainModels(): List<LocationDomainModel> {
        return listOf(
            LocationDomainModel("New York"),
            LocationDomainModel("Los Angeles"),
            LocationDomainModel("Chicago")
        )
    }

}