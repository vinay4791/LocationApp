package com.nordsec.locationapp.di

import com.nordsec.locationapp.common.Utils
import org.koin.dsl.module

val utilsModule = module {
    single {
        Utils()
    }
}