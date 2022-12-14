package com.hugh.detail.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hugh.base.BaseActivity
import com.hugh.detail.R
import com.hugh.detail.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryDetail : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val categoryDetailViewModel: CategoryDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        binding.viewModel = categoryDetailViewModel

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                categoryDetailViewModel.bookmarkToggle.collectLatest { toggle ->
                    when (toggle) {
                        true -> {
                            binding.bookmark.setBackgroundResource(R.drawable.bookmark_color)
                        }
                        false -> {
                            binding.bookmark.setBackgroundResource(R.drawable.bookmark)
                        }
                    }
                }
            }
        }
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_700))
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}