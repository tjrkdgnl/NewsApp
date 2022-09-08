package com.hugh.category.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hugh.CategoryType
import com.hugh.category.data.paging.CategoryListPagingSource
import com.hugh.category.domain.repository.CategoryRepository
import com.hugh.coroutine.IoDispatcher
import com.hugh.entity.ArticleEntity
import com.hugh.network.Constant
import com.hugh.network.state.ArticlesState
import com.hugh.network.state.CountryType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class CategoryRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource
) : CategoryRepository {

    override fun getCategoryListFlow(
        category: CategoryType,
        countryType: CountryType
    ): Flow<PagingData<ArticleEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constant.INITIAL_LOAD_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CategoryListPagingSource(this, category, countryType) }
        ).flow
    }

    override suspend fun getCategoryList(
        category: CategoryType,
        countryType: CountryType,
        page: Int,
        pageSize: Int
    ): ArticlesState {
        return remoteDataSource.getCategoryList(category, countryType, page, pageSize)
    }

    override fun getCategoryTypeList(): List<CategoryType> {
        return listOf(
            CategoryType.BUSINESS,
            CategoryType.ENTERTAINMENT,
            CategoryType.GENERAL,
            CategoryType.SCIENCE,
            CategoryType.HEALTH,
            CategoryType.SPORTS,
            CategoryType.TECHNOLOGY
        )
    }
}