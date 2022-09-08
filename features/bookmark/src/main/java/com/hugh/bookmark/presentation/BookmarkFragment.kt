package com.hugh.bookmark.presentation

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hugh.bookmark.R
import com.hugh.bookmark.databinding.FragmentBookmarkBinding
import com.hugh.bookmark.presentation.adapter.BookmarkAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BookmarkFragment : Fragment(R.layout.fragment_bookmark) {

    private lateinit var binding: FragmentBookmarkBinding
    private val bookmarkViewModel: BookmarkViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = viewLifecycleOwner

        binding.recyclerView.apply {
            adapter = BookmarkAdapter()
        }

//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                bookmarkViewModel.articlesFlow.collectLatest {
//                    (binding.recyclerView.adapter as BookmarkAdapter).submitList(it)
//                }
//            }
//        }
    }
}