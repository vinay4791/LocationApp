package com.nordsec.locationapp.rx

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableSource
import io.reactivex.rxjava3.core.CompletableTransformer
import io.reactivex.rxjava3.core.Scheduler


/**
 * This  class exposes two static functions  which returns a Completable with the attached subscribing or observing scheduler
 */
class CompletableSchedulingStrategy constructor(private val subscribingScheduler: Scheduler,
                                                private val observingScheduler: Scheduler
) : CompletableTransformer {
    override fun apply(upstream: Completable): CompletableSource {
        return upstream
                .subscribeOn(subscribingScheduler)
                .observeOn(observingScheduler)
    }
}
