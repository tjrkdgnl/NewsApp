package com.hugh.category.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.appbar.MaterialToolbar
import com.hugh.CategoryType
import com.hugh.category.R

object BindingAdapterObj {

    @JvmStatic
    @BindingAdapter("categoryItem")
    fun setCategoryItem(textView: TextView, categoryType: CategoryType) {
        when (categoryType) {
            CategoryType.BUSINESS -> {
                textView.text = categoryType.toString()
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.business, 0, 0)
            }
            CategoryType.ENTERTAINMENT -> {
                textView.text = categoryType.toString()
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.entertainment, 0, 0)
            }
            CategoryType.GENERAL -> {
                textView.text = categoryType.toString()
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.general, 0, 0)
            }
            CategoryType.HEALTH -> {
                textView.text = categoryType.toString()
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.health, 0, 0)
            }
            CategoryType.SCIENCE -> {
                textView.text = categoryType.toString()
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.science, 0, 0)
            }
            CategoryType.SPORTS -> {
                textView.text = categoryType.toString()
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sports, 0, 0)
            }
            CategoryType.TECHNOLOGY -> {
                textView.text = categoryType.toString()
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.technology, 0, 0)
            }
            else -> {}
        }
    }

    @JvmStatic
    @BindingAdapter("articleImage")
    fun setArticleImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade(90))
            .error(R.drawable.placeholder_gray)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("setToolbarTitle")
    fun setToolbarTitle(toolbar: MaterialToolbar, categoryType: CategoryType?) {
        categoryType?.let { type ->
            when (type) {
                CategoryType.BUSINESS -> toolbar.title = "????????????"
                CategoryType.ENTERTAINMENT -> toolbar.title = "??????????????????"
                CategoryType.GENERAL -> toolbar.title = "?????????"
                CategoryType.HEALTH -> toolbar.title = "??????"
                CategoryType.SCIENCE -> toolbar.title = "????????????"
                CategoryType.SPORTS -> toolbar.title = "?????????"
                CategoryType.TECHNOLOGY -> toolbar.title = "???????????????"
                CategoryType.NONE -> {}
            }
        }
    }
}
