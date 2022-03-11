package com.k10tetry.android_mvvm_boilerplate.data.local.preference

interface AppPreferenceHelper {

    fun isLoggedIn(): Boolean

    fun setLoggedIn(loggedIn: Boolean)
}