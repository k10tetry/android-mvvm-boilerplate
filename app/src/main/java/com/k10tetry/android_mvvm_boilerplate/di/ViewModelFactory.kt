package com.k10tetry.android_mvvm_boilerplate.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider

class ViewModelProviderFactory<T : ViewModel>(
    private val viewModelClass: Class<T>,
    private val viewModelProvider: Provider<T>
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModelClass)) {
            return viewModelProvider.get() as T
        } else {
            throw IllegalArgumentException("Unknow Class name ${viewModelClass.name}")
        }
    }
}