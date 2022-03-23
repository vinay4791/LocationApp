package com.nordsec.locationapp.common

import com.nordsec.locationapp.locations.data.Location
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UtilsTest {

    @Test
    fun `check converstion`(){
        val util = Utils()
        util.getLocationListSortedWithSelectedLocation("New York")
    }

}