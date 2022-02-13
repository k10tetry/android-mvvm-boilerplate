package com.k10tetry.android_mvvm_boilerplate.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.k10tetry.android_mvvm_boilerplate.data.remote.model.Post
import com.k10tetry.android_mvvm_boilerplate.databinding.ItemviewMainBinding
import com.k10tetry.android_mvvm_boilerplate.ui.base.BaseRecycleAdapter
import com.k10tetry.android_mvvm_boilerplate.ui.base.BaseViewHolder
import javax.inject.Inject

class MainAdapter @Inject constructor() : BaseRecycleAdapter<Post>() {
    override fun getViewHolder(parent: ViewGroup): BaseViewHolder<Post> {
        return MainViewHolder(
            ItemviewMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class MainViewHolder(private val binding: ItemviewMainBinding) :
        BaseViewHolder<Post>(binding.root) {
        override fun onBind(data: Post) {
            binding.itemviewText.text = data.title
        }
    }
}