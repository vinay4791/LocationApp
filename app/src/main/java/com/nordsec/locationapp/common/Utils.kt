package com.nordsec.locationapp.common

import com.google.gson.Gson
import com.nordsec.locationapp.App
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

}