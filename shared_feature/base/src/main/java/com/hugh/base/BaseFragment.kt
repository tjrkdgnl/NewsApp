package com.hugh.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

open class BaseFragment<T : ViewDataBinding>(@LayoutRes layout: Int) : Fragment(layout) {

    private var bindingObj: T? = null

    protected val binding: T by lazy {
        bindingObj!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingObj = DataBindingUtil.bind(view)
        bindingObj?.lifecycleOwner = this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingObj = null
    }
}