package com.hugh.bookmark.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hugh.bookmark.R
import com.hugh.bookmark.databinding.FragmentBookmarkBinding
import com.hugh.bookmark.presentation.adapter.BookmarkAdapter
import com.hugh.callback.FragmentNavigator
import com.hugh.util.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class BookmarkFragment : Fragment(R.layout.fragment_bookmark) {

    private lateinit var binding: FragmentBookmarkBinding
    private val bookmarkViewModel: BookmarkViewModel by viewModels()

    @Inject
    lateinit var fragmentNavigator: FragmentNavigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = viewLifecycleOwner

        binding.recyclerView.apply {
            adapter = BookmarkAdapter {
                fragmentNavigator.bookmarkToCategoryDetail(it)
            }
            addItemDecoration(GridSpacingItemDecoration(1, 30))
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                bookmarkViewModel.articlesFlow.collectLatest { articles ->

                    binding.emptyBookmarkText.isVisible = articles.isEmpty()
                    (binding.recyclerView.adapter as BookmarkAdapter).submitList(articles)
                }
            }
        }
    }
}