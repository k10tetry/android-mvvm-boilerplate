package com.k10tetry.android_mvvm_boilerplate.ui.base

import androidx.lifecycle.ViewModel
import com.k10tetry.android_mvvm_boilerplate.utils.rx.SchedulerProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable
) : ViewModel() {
}