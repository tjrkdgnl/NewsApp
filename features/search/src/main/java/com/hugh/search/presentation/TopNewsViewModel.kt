package com.hugh.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hugh.entity.ArticleEntity
import com.hugh.search.domain.usecase.SearchUseCase
import com.hugh.search.presentation.state.UiState
import com.hugh.search.presentation.state.UserAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopNewsViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    val state: StateFlow<UiState>

    val pagingDataFlow : Flow<PagingData<ArticleEntity>>

    val accept: (UserAction) -> Unit

    init {
        val actionSearchFlow = MutableSharedFlow<UserAction>()
        val searches = actionSearchFlow
            .filterIsInstance<UserAction.Search>()
            .distinctUntilChanged()
            .onStart { emit(UserAction.Search(keyword = "")) }

        pagingDataFlow = searches
            .flatMapLatest { searchUseCase.search(keyword = it.keyword) }
            .cachedIn(viewModelScope)

        state = searches.map {
            UiState(keyword = it.keyword)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 3000),
            initialValue = UiState()
        )

        accept = { action ->
            viewModelScope.launch { actionSearchFlow.emit(action) }
        }
    }
}