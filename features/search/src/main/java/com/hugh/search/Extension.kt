package com.hugh.search

import android.content.Context
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.hugh.entity.ArticleEntity
import com.hugh.search.databinding.FragmentSearchBinding
import com.hugh.search.presentation.adapter.SearchAdapter
import com.hugh.search.presentation.state.UserAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


fun FragmentSearchBinding.bindState(
    pagingData: Flow<PagingData<ArticleEntity>>,
    accept: (UserAction) -> Unit,
    scope: CoroutineScope,
    adapter: SearchAdapter
) {
    bindSearch(onKeywordChange = accept)

    bindList(
        adapter = adapter,
        pagingData = pagingData,
        scope = scope
    )
}

fun FragmentSearchBinding.bindSearch(
    onKeywordChange: (UserAction.Search) -> Unit,
) {
    searchEditText.setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_GO) {
            updateRepoListFromInput(onKeywordChange)
            true
        } else {
            false
        }
    }
    searchEditText.setOnKeyListener { _, keyCode, event ->
        if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
            updateRepoListFromInput(onKeywordChange)
            true
        } else {
            false
        }
    }
}

fun FragmentSearchBinding.updateRepoListFromInput(
    onKeywordChange: (UserAction.Search) -> Unit,
) {
    searchEditText.text.trim().let {
        if (it.isNotEmpty()) {
            this.recyclerView.scrollToPosition(0)
            onKeywordChange(UserAction.Search(keyword = it.toString()))
            searchEditText.setSelection(it.length)
            hideKeyboard()
        }
    }
}

fun FragmentSearchBinding.bindList(
    adapter: SearchAdapter,
    pagingData: Flow<PagingData<ArticleEntity>>,
    scope: CoroutineScope
) {
    scope.launch {
        lifecycleOwner!!.repeatOnLifecycle(Lifecycle.State.STARTED) {
            adapter.loadStateFlow.collectLatest {
                progressBar.isVisible = it.refresh is LoadState.Loading
                emptyResultText.isVisible =
                    it.refresh is LoadState.NotLoading && adapter.itemCount == 0
                errorText.isVisible = it.refresh is LoadState.Error
            }
        }
    }

    scope.launch {
        lifecycleOwner!!.repeatOnLifecycle(Lifecycle.State.STARTED) {
            pagingData.collect(adapter::submitData)
        }
    }
}

fun FragmentSearchBinding.showKeyboard() {
    searchEditText.requestFocus()

    root.postDelayed({
        val imm = root.context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.showSoftInput(searchEditText, 1)
    }, 100)
}

fun FragmentSearchBinding.hideKeyboard() {
    val imm = root.context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(searchEditText.windowToken, 0)
}