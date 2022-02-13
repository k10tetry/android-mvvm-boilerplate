package com.k10tetry.android_mvvm_boilerplate

import android.app.Application
import com.k10tetry.android_mvvm_boilerplate.di.components.ApplicationComponent
import com.k10tetry.android_mvvm_boilerplate.di.components.DaggerApplicationComponent
import com.k10tetry.android_mvvm_boilerplate.di.modules.ApplicationModule

class MainApp : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this@MainApp)).build()
    }
}