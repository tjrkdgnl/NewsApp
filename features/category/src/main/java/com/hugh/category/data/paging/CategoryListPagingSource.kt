package com.hugh.category.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.repository.CategoryRepository
import com.hugh.category.domain.state.ArticlesState
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType
import com.hugh.network.Constant

internal class CategoryListPagingSource(
    private val articleRepository: CategoryRepository,
    private val categoryType: CategoryType,
    private val countryType: CountryType
) : PagingSource<Int, ArticleEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleEntity> {
        val page = params.key ?: Constant.DEFAULT_PAGE_KEY
        val size = params.loadSize

        val state = articleRepository.getCategoryList(
            categoryType, countryType, page, size
        )

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