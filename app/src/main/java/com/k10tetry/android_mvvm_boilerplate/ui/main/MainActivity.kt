package com.k10tetry.android_mvvm_boilerplate.ui.main

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.k10tetry.android_mvvm_boilerplate.data.remote.api.ApiService
import com.k10tetry.android_mvvm_boilerplate.databinding.ActivityMainBinding
import com.k10tetry.android_mvvm_boilerplate.di.ViewModelProviderFactory
import com.k10tetry.android_mvvm_boilerplate.di.components.ActivityComponent
import com.k10tetry.android_mvvm_boilerplate.ui.base.BaseActivity
import com.k10tetry.android_mvvm_boilerplate.utils.rx.AppSchedulerProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    @Inject
    lateinit var mainAdapter: MainAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var apiService: ApiService

    override fun performInjection(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun init() {

        viewBinding.mainRecycleview.apply {
            adapter = mainAdapter
            layoutManager = linearLayoutManager
        }

        viewModel.isloading.observe(this, {
            viewBinding.mainProgressbar.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.posts.observe(this, {
            mainAdapter.itemList = ArrayList(it)
        })
    }
}