package com.nordsec.locationapp.common

import com.google.gson.Gson
import com.nordsec.locationapp.App
import com.nordsec.locationapp.locations.data.Location
import com.nordsec.locationapp.locations.data.Locations
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class Utils {

    fun getLocationsList(): Locations {
        val inputStream: InputStream = App.context.assets.open("data.json")
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        return Gson().fromJson(bufferReader, Locations::class.java)
    }

    fun getLocationListSortedWithSelectedLocation(location: Location): Locations {
        TODO("Not yet implemented")
    }

    private fun distance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val theta = lon1 - lon2
        var dist = (Math.sin(deg2rad(lat1))
            * Math.sin(deg2rad(lat2))
            + (Math.cos(deg2rad(lat1))
            * Math.cos(deg2rad(lat2))
            * Math.cos(deg2rad(theta))))
        dist = Math.acos(dist)
        dist = rad2deg(dist)
        dist = dist * 60 * 1.1515
        return dist
    }

    private fun deg2rad(deg: Double): Double {
        return deg * Math.PI / 180.0
    }

    private fun rad2deg(rad: Double): Double {
        return rad * 180.0 / Math.PI
    }

}