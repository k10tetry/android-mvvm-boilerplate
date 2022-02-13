package com.k10tetry.android_mvvm_boilerplate.di.modules

import android.app.Application
import android.content.Context
import com.k10tetry.android_mvvm_boilerplate.data.remote.api.ApiService
import com.k10tetry.android_mvvm_boilerplate.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApplicationModule(private val application: Application) {

    @Singleton
    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Singleton
    @Provides
    fun provideCommonApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}