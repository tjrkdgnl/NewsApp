package com.hugh.search.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hugh.entity.ArticleEntity
import com.hugh.network.Constant
import com.hugh.network.state.ArticlesState
import com.hugh.search.domain.repository.SearchRepository

internal class SearchPagingSource(
    private val articleRepository: SearchRepository,
    private val keyword: String
) : PagingSource<Int, ArticleEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleEntity> {
        val page = params.key ?: Constant.DEFAULT_PAGE_KEY
        val size = params.loadSize

        val state = articleRepository.search(keyword, page, size)

        return when (state) {
            is ArticlesState.Success -> {
                val nextKey = if (state.articlesEntity.articles.isEmpty())
                    null
                else {
                    //초기 페이지 =  3 * INITIAL_LOAD_SIZE
                    page + (params.loadSize / Constant.INITIAL_LOAD_SIZE)
                }

                LoadResult.Page(
                    data = state.articlesEntity.articles,
                    prevKey = if (page == Constant.DEFAULT_PAGE_KEY) null else page - 1,
                    nextKey = nextKey
                )
            }

            is ArticlesState.Failure -> {
                LoadResult.Error(state.throwable)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ArticleEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}