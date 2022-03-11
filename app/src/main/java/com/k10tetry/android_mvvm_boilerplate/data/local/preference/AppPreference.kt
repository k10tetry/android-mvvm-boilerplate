package com.k10tetry.android_mvvm_boilerplate.data.local.preference

import android.content.Context
import android.content.SharedPreferences
import com.k10tetry.android_mvvm_boilerplate.di.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreference @Inject constructor(@ApplicationContext context: Context) : AppPreferenceHelper {

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MVVM", Context.MODE_PRIVATE)

    override fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(AppPreferenceConstant.IS_LOGGED_IN, false)
    }

    override fun setLoggedIn(loggedIn: Boolean) {
        sharedPreferences.edit().run {
            putBoolean(AppPreferenceConstant.IS_LOGGED_IN, loggedIn)
            apply()
        }
    }

}