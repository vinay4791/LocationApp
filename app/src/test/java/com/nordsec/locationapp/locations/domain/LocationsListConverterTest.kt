package com.nordsec.locationapp.locations.domain


import com.google.common.truth.Truth
import com.nordsec.locationapp.locations.data.Location
import com.nordsec.locationapp.locations.data.Locations
import org.junit.Before
import org.junit.Test

class LocationsListConverterTest {

    private lateinit var locationsListConverter: LocationsListConverter

    @Before
    fun setUp() {
        locationsListConverter = LocationsListConverter()
    }

    @Test
    fun `should convert list of location api response to review viewstate`() {
        val convertedViewState = locationsListConverter.apply(getMockLocationListResponse())
        val expected = LocationsViewState.Success(getSortedLocationDomainModels())
        Truth.assertThat(convertedViewState).isEqualTo(expected)
    }

    /**
     * Returns the mock location List response
     */

    private fun getMockLocationListResponse(): Locations {
        return Locations(
            location = listOf(
                Location(
                    city = "New York",
                    latitude = 40.712784F,
                    longitude = -74.00594F
                ),
                Location(
                    city = "Los Angeles",
                    latitude = 34.052235F,
                    longitude = -118.24368F
                ),
                Location(
                    city = "Chicago",
                    latitude = 41.878113F,
                    longitude = -87.6298F
                )
            )
        )
    }

    private fun getSortedLocationDomainModels(): List<LocationDomainModel> {
        return listOf(
            LocationDomainModel("Chicago"),
            LocationDomainModel("Los Angeles"),
            LocationDomainModel("New York")
        )
    }

}