package com.hugh.top_news.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hugh.entity.ArticleEntity
import com.hugh.network.Constant
import com.hugh.network.state.ArticlesState
import com.hugh.network.state.CountryType
import com.hugh.top_news.data.repository.RemoteDataSource

internal class TopNewsPagingSource(
    private val remoteDataSource: RemoteDataSource,
    private val countryType: CountryType
) : PagingSource<Int, ArticleEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleEntity> {
        val page = params.key ?: Constant.DEFAULT_PAGE_KEY

        return when (val state = remoteDataSource.getTopNews(countryType, page, params.loadSize)) {
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
                LoadResult.Error(
                    throwable = state.throwable
                )
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