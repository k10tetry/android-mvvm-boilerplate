package com.k10tetry.android_mvvm_boilerplate.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.k10tetry.android_mvvm_boilerplate.data.remote.api.ApiService
import com.k10tetry.android_mvvm_boilerplate.data.remote.model.Post
import com.k10tetry.android_mvvm_boilerplate.ui.base.BaseViewModel
import com.k10tetry.android_mvvm_boilerplate.utils.rx.SchedulerProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainViewModel(
    private val apiService: ApiService,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(schedulerProvider, compositeDisposable) {
    private val _posts: MutableLiveData<List<Post>> = MutableLiveData(emptyList())
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    val isloading: LiveData<Boolean> = _isLoading
    val posts: LiveData<List<Post>> = _posts

    init {
        loadPosts()
    }

    private fun loadPosts() {
        compositeDisposable.add(apiService.getPosts()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe {
                _isLoading.value = true
            }
            .subscribe({ posts ->
                _isLoading.value = false
                _posts.value = posts
            }, {
                _isLoading.value = false
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}