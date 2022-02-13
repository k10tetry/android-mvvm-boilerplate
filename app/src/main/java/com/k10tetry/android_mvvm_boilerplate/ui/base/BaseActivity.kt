package com.k10tetry.android_mvvm_boilerplate.ui.base

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.k10tetry.android_mvvm_boilerplate.MainApp
import com.k10tetry.android_mvvm_boilerplate.di.components.ActivityComponent
import com.k10tetry.android_mvvm_boilerplate.di.components.DaggerActivityComponent
import com.k10tetry.android_mvvm_boilerplate.di.modules.ActivityModule
import javax.inject.Inject


abstract class BaseActivity<VM : ViewModel, VB : ViewBinding> : AppCompatActivity() {

    lateinit var viewBinding: VB
        private set

    @Inject
    lateinit var viewModel: VM

    abstract fun performInjection(activityComponent: ActivityComponent)

    abstract fun setViewBinding(): VB

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        performInjection(getActivityComponent())
        super.onCreate(savedInstanceState)
        viewBinding = setViewBinding()
        setContentView(viewBinding.root)
        init()
    }

    private fun getActivityComponent(): ActivityComponent {
        return DaggerActivityComponent.builder().run {
            applicationComponent((applicationContext as MainApp).applicationComponent)
            activityModule(ActivityModule(this@BaseActivity))
            build()
        }
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}