package com.k10tetry.android_mvvm_boilerplate.di.modules

import com.k10tetry.android_mvvm_boilerplate.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().run {
            baseUrl(BuildConfig.BASE_URL)
            client(okHttpClient)
            addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
            build()
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().run {
            addInterceptor(httpLoggingInterceptor)
            build()
        }
    }

    @Singleton
    @Provides
    fun providehttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}