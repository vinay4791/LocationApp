package com.nordsec.locationapp.di

import com.nordsec.locationapp.locations.di.locationListModule


val locationAppModules = listOf(
    utilsModule,
    locationListModule
)