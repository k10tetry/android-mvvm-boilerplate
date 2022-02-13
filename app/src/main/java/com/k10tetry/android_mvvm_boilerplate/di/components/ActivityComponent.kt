package com.k10tetry.android_mvvm_boilerplate.di.components

import com.k10tetry.android_mvvm_boilerplate.di.modules.ActivityModule
import com.k10tetry.android_mvvm_boilerplate.di.scopes.PerActivity
import com.k10tetry.android_mvvm_boilerplate.ui.main.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}