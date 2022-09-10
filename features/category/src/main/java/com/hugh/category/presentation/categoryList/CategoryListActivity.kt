package com.hugh.category.presentation.categoryList

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.hugh.base.BaseActivity
import com.hugh.category.R
import com.hugh.category.databinding.ActivityListBinding
import com.hugh.category.presentation.categoryList.adapter.CategoryDetailPagingAdapter
import com.hugh.navigator.CategoryDetailNavigator
import com.hugh.util.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CategoryListActivity : BaseActivity<ActivityListBinding>(R.layout.activity_list) {

    private val categoryListViewModel: CategoryListViewModel by viewModels()

    @Inject
    lateinit var categoryDetailNavigator: CategoryDetailNavigator

    private val categoryAdapter = CategoryDetailPagingAdapter { article ->
        binding.root.context.startActivity(
            categoryDetailNavigator.intent(
                binding.root.context,
                article
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryListViewModel.retryState.observe(this) { retry ->
            if (retry) {
                categoryAdapter.retry()
                categoryListViewModel.retryInit()
            }
        }

        binding.pagingRecyclerView.apply {
            adapter = categoryAdapter
            addItemDecoration(GridSpacingItemDecoration(1, 30))
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                categoryAdapter.loadStateFlow.collect { loadState ->
                    binding.progressBar.isVisible = loadState.refresh is LoadState.Loading
                    binding.errorLayout.isVisible = loadState.refresh is LoadState.Error ||
                            loadState.refresh is LoadState.NotLoading && categoryAdapter.itemCount == 0
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                categoryListViewModel.categoryDetailFlow.collectLatest {
                    categoryAdapter.submitData(it)
                }
            }
        }
    }
}