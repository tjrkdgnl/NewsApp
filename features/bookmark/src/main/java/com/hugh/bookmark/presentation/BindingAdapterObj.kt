package com.hugh.bookmark.presentation

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.hugh.bookmark.R

object BindingAdapterObj {


    @JvmStatic
    @BindingAdapter("articleImage")
    fun setArticleImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade(90))
            .error(R.drawable.placeholder_gray)
            .into(imageView)
    }
}