package com.hugh.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : ViewDataBinding, I : Any>(
    parent: ViewGroup,
    @LayoutRes layout: Int
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layout, parent, false)
) {

    protected val binding: T = DataBindingUtil.bind(itemView)!!

    abstract fun bind(item: I)
}