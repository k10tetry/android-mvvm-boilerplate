package com.k10tetry.android_mvvm_boilerplate.utils.rx

import io.reactivex.rxjava3.core.Scheduler

interface SchedulerProvider {
    fun ui(): Scheduler
    fun io(): Scheduler
    fun computation(): Scheduler
}