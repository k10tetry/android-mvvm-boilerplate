package com.k10tetry.android_mvvm_boilerplate.di.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.k10tetry.android_mvvm_boilerplate.data.remote.api.ApiService
import com.k10tetry.android_mvvm_boilerplate.di.ViewModelFactory
import com.k10tetry.android_mvvm_boilerplate.di.qualifiers.ActivityContext
import com.k10tetry.android_mvvm_boilerplate.di.scopes.PerActivity
import com.k10tetry.android_mvvm_boilerplate.ui.main.MainViewModel
import com.k10tetry.android_mvvm_boilerplate.utils.rx.AppSchedulerProvider
import com.k10tetry.android_mvvm_boilerplate.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Provider


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

    @PerActivity
    @Provides
    fun provideViewModel(
        activity: AppCompatActivity,
        apiService: ApiService,
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable
    ): MainViewModel {
        val provider: Provider<MainViewModel> =
            Provider<MainViewModel> {
                MainViewModel(
                    apiService,
                    schedulerProvider,
                    compositeDisposable
                )
            }
        val viewModelProviderFactory =
            ViewModelFactory(MainViewModel::class.java, provider);
        return ViewModelProvider(activity, viewModelProviderFactory).get(MainViewModel::class.java)
    }

}