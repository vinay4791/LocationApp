package com.nordsec.locationapp.locations.data

import com.google.gson.annotations.SerializedName

data class Locations(@SerializedName("locations") val location: List<Location>)