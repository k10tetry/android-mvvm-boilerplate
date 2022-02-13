package com.k10tetry.android_mvvm_boilerplate.data.remote.api

import com.k10tetry.android_mvvm_boilerplate.data.remote.model.Post
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    fun getPosts(): Single<List<Post>>

}