package com.hugh.search.presentation.state

sealed class UserAction {
    data class Search(val keyword: String) : UserAction()
}