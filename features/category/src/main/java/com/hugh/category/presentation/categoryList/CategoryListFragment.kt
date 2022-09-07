package com.hugh.category.presentation.categoryList

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.hugh.category.R
import com.hugh.category.databinding.FragmentDetailBinding
import com.hugh.category.presentation.category.adapter.GridSpacingItemDecoration
import com.hugh.category.presentation.categoryList.adapter.CategoryDetailPagingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var binding: FragmentDetailBinding
    private val categoryListlViewModel: CategoryListlViewModel by viewModels()

    private val categoryAdapter = CategoryDetailPagingAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.viewModel = categoryListlViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        categoryListlViewModel.retryState.observe(viewLifecycleOwner) { retry ->
            if (retry) {
                categoryAdapter.retry()
                categoryListlViewModel.retryInit()
            }
        }

        binding.pagingRecyclerView.apply {
            adapter = categoryAdapter
            addItemDecoration(GridSpacingItemDecoration(1, 30))
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                categoryAdapter.loadStateFlow.collect { loadState ->
                    binding.progressBar.isVisible = loadState.refresh is LoadState.Loading
                    binding.errorLayout.isVisible = loadState.refresh is LoadState.Error
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                categoryListlViewModel.categoryDetailFlow.collectLatest {
                    categoryAdapter.submitData(it)
                }
            }
        }
    }
}