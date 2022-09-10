package com.hugh.top_news.presentation

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
import com.hugh.navigator.CategoryDetailNavigator
import com.hugh.top_news.R
import com.hugh.top_news.databinding.FragmentTopnewsBinding
import com.hugh.top_news.presentation.adapter.TopNewsAdapter
import com.hugh.util.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class TopNewsFragment : Fragment(R.layout.fragment_topnews) {

    private lateinit var binding: FragmentTopnewsBinding

    private val topNewsViewModel: TopNewsViewModel by viewModels()

    @Inject
    lateinit var detailNavigator: CategoryDetailNavigator

    private val topNewsAdapter = TopNewsAdapter {
        binding.root.context.startActivity(detailNavigator.intent(binding.root.context, it))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = topNewsViewModel

        binding.recyclerView.apply {
            adapter = topNewsAdapter
            addItemDecoration(GridSpacingItemDecoration(1, 30))
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                topNewsAdapter.loadStateFlow.collectLatest { loadState ->
                    binding.progressBar.isVisible = loadState.refresh is LoadState.Loading
                    binding.errorLayout.isVisible = loadState.refresh is LoadState.Error
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                topNewsViewModel.topNewsFlow.collectLatest {
                    topNewsAdapter.submitData(it)
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                topNewsViewModel.retryFlow.collectLatest { retry ->
                    if (retry) topNewsAdapter.retry()
                }
            }
        }
    }
}