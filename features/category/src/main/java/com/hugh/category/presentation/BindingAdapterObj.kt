package com.hugh.category.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.appbar.MaterialToolbar
import com.hugh.CategoryType
import com.hugh.category.R
import com.hugh.mylibrary.BitmapCreator
import com.hugh.mylibrary.LruCacheCreator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        CoroutineScope(Dispatchers.Main).launch {
            url?.let {
                val bitmap = LruCacheCreator.getInstance().get(url) ?: run {
                    LruCacheCreator.decodeThumbNailBitmapFromResource(
                        res = imageView.context.resources,
                        resId = R.id.articleImage,
                        reqWidth = 100,
                        reqHeight = 100
                    )?.also {
                        LruCacheCreator.getInstance().put(url, it)
                    }
                }
                imageView.setImageBitmap(bitmap)
            }
        }
        Glide.with(imageView.context)
            .load(url)
            .thumbnail()
            .transition(DrawableTransitionOptions.withCrossFade(90))
            .error(R.drawable.placeholder_gray)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("setToolbarTitle")
    fun setToolbarTitle(toolbar: MaterialToolbar, categoryType: CategoryType?) {
        categoryType?.let { type ->
            when (type) {
                CategoryType.BUSINESS -> toolbar.title = "비즈니스"
                CategoryType.ENTERTAINMENT -> toolbar.title = "엔터테인먼트"
                CategoryType.GENERAL -> toolbar.title = "제네럴"
                CategoryType.HEALTH -> toolbar.title = "헬스"
                CategoryType.SCIENCE -> toolbar.title = "사이언스"
                CategoryType.SPORTS -> toolbar.title = "스포츠"
                CategoryType.TECHNOLOGY -> toolbar.title = "테크놀로지"
                CategoryType.NONE -> {}
            }
        }
    }
}
