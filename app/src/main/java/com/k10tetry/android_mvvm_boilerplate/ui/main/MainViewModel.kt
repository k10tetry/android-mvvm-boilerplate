package com.k10tetry.android_mvvm_boilerplate.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.k10tetry.android_mvvm_boilerplate.data.remote.api.ApiService
import com.k10tetry.android_mvvm_boilerplate.data.remote.model.Post
import com.k10tetry.android_mvvm_boilerplate.di.scopes.PerActivity
import com.k10tetry.android_mvvm_boilerplate.utils.rx.SchedulerProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@PerActivity
class MainViewModel @Inject constructor(
    private val apiService: ApiService,
    private val schedulerProvider: SchedulerProvider,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {
    private val _posts: MutableLiveData<List<Post>> = MutableLiveData(emptyList())
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    val isloading: LiveData<Boolean> = _isLoading
    val posts: LiveData<List<Post>> = _posts

    init {
        loadPosts()
    }

    private fun loadPosts() {
        compositeDisposable.add(apiService.getPosts().run {
            subscribeOn(schedulerProvider.io())
            observeOn(schedulerProvider.ui())
            doOnSubscribe {
                _isLoading.postValue(true)
            }
            subscribe({ posts ->
                _isLoading.postValue(false)
                _posts.postValue(posts)
            }, {
                _isLoading.postValue(false)
            })
        })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}