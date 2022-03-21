package com.nordsec.locationapp.rx

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

open class TestSchedulingStrategyFactory(subscribingScheduler: Scheduler, observingScheduler: Scheduler) :
    SchedulingStrategyFactory(subscribingScheduler, observingScheduler) {
    companion object {
        fun immediate(): TestSchedulingStrategyFactory {
            return TestSchedulingStrategyFactory(Schedulers.trampoline(), Schedulers.trampoline())
        }
    }
}