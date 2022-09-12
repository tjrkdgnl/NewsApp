package com.hugh.top_news.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.hugh.network.state.CountryType
import com.hugh.top_news.domain.usecase.TopNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class TopNewsViewModel @Inject constructor(
    private val topNewsUseCase: TopNewsUseCase
) : ViewModel() {

    val retryFlow = MutableSharedFlow<Boolean>()

    val topNewsFlow = topNewsUseCase.topNewsFlow(CountryType.US)
        .cachedIn(viewModelScope)


    fun retry() {
        viewModelScope.launch {
            retryFlow.emit(true)
        }
    }
}