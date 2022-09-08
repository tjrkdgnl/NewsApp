package com.hugh.category.presentation.categoryDetail

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hugh.category.R
import com.hugh.category.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryDetail : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding

    private val categoryDetailViewModel: CategoryDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = viewLifecycleOwner

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
}