package com.hugh.search.presentation

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.hugh.navigator.CategoryDetailNavigator
import com.hugh.search.R
import com.hugh.search.databinding.FragmentSearchBinding
import com.hugh.search.presentation.adapter.SearchAdapter
import com.hugh.search.bindState
import com.hugh.search.showKeyboard
import com.hugh.util.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var binding: FragmentSearchBinding

    private val topNewsViewModel: TopNewsViewModel by viewModels()

    @Inject
    lateinit var detailNavigator: CategoryDetailNavigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = viewLifecycleOwner

        binding.showKeyboard()

        binding.recyclerView.apply {
            adapter = SearchAdapter {
                binding.root.context.startActivity(detailNavigator.intent(binding.root.context, it))
            }
            addItemDecoration(GridSpacingItemDecoration(1, 30))
        }

        binding.bindState(
            pagingData = topNewsViewModel.pagingDataFlow,
            accept = topNewsViewModel.accept,
            scope = lifecycleScope,
            adapter = binding.recyclerView.adapter as SearchAdapter
        )
    }
}