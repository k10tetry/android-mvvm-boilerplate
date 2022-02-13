package com.k10tetry.android_mvvm_boilerplate.ui.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecycleAdapter<T> :
    RecyclerView.Adapter<BaseViewHolder<T>>() {

    abstract fun getViewHolder(parent: ViewGroup): BaseViewHolder<T>

    var itemList = ArrayList<T>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}