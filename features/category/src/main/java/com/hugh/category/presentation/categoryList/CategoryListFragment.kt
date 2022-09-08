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
import com.hugh.callback.FragmentNavigator
import com.hugh.category.R
import com.hugh.category.databinding.FragmentListBinding
import com.hugh.category.presentation.categoryList.adapter.CategoryDetailPagingAdapter
import com.hugh.util.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CategoryListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var binding: FragmentListBinding
    private val categoryListViewModel: CategoryListViewModel by viewModels()

    @Inject
    lateinit var fragmentNavigator: FragmentNavigator

    private val categoryAdapter = CategoryDetailPagingAdapter { article ->
        fragmentNavigator.categoryListToCategoryDetail(article)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.viewModel = categoryListViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        categoryListViewModel.retryState.observe(viewLifecycleOwner) { retry ->
            if (retry) {
                categoryAdapter.retry()
                categoryListViewModel.retryInit()
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
                    binding.errorLayout.isVisible = loadState.refresh is LoadState.Error ||
                            loadState.refresh is LoadState.NotLoading && categoryAdapter.itemCount == 0
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                categoryListViewModel.categoryDetailFlow.collectLatest {
                    categoryAdapter.submitData(it)
                }
            }
        }
    }
}