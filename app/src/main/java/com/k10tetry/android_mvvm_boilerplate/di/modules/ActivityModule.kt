package com.k10tetry.android_mvvm_boilerplate.di.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.k10tetry.android_mvvm_boilerplate.di.qualifiers.ActivityContext
import com.k10tetry.android_mvvm_boilerplate.utils.rx.AppSchedulerProvider
import com.k10tetry.android_mvvm_boilerplate.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable


@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideActivity(): AppCompatActivity {
        return activity
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideLinearLayoutManager(@ActivityContext context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @Provides
    fun provideScheduleProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

}