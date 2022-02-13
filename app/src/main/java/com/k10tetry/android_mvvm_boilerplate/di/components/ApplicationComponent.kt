package com.k10tetry.android_mvvm_boilerplate.di.components

import android.app.Application
import android.content.Context
import com.k10tetry.android_mvvm_boilerplate.data.remote.api.ApiService
import com.k10tetry.android_mvvm_boilerplate.di.modules.ApplicationModule
import com.k10tetry.android_mvvm_boilerplate.di.modules.NetworkModule
import com.k10tetry.android_mvvm_boilerplate.di.qualifiers.ApplicationContext
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {

    @ApplicationContext
    fun getContext(): Context

    fun getApplication(): Application

    fun getCommonApiService(): ApiService

}