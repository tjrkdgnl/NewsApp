package com.hugh.category.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hugh.category.data.paging.CategoryDetailPagingSource
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.repository.CategoryRepository
import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType
import com.hugh.coroutine.IoDispatcher
import com.hugh.network.Constant
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class CategoryRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource
) : CategoryRepository {

    override fun getCategoryDetailFlow(
        category: CategoryType,
        countryType: CountryType
    ): Flow<PagingData<ArticleEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constant.INITIAL_LOAD_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CategoryDetailPagingSource(this, category, countryType) }
        ).flow
    }

    override suspend fun getCategoryDetailList(
        category: CategoryType,
        countryType: CountryType,
        page: Int,
        pageSize: Int
    ): ArticleState {
        return remoteDataSource.getCategoryDetailList(category, countryType, page, pageSize)
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