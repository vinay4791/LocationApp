package com.nordsec.locationapp.rx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * This  class exposes two static functions for deciding which scheduler the observable should subscribeOn
 */
class AndroidSchedulingStrategyFactory(subscribingScheduler: Scheduler) :
        SchedulingStrategyFactory(subscribingScheduler, AndroidSchedulers.mainThread()) {

    companion object {
        fun newThread(): AndroidSchedulingStrategyFactory {
            return AndroidSchedulingStrategyFactory(Schedulers.newThread())
        }

        fun io(): AndroidSchedulingStrategyFactory {
            return AndroidSchedulingStrategyFactory(Schedulers.io())
        }
    }

}
