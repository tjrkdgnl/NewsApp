package com.hugh.category.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006JE\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/hugh/category/data/repository/ArticleRepositoryImpl;", "Lcom/hugh/category/domain/repository/ArticleRepository;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "remoteDataSource", "Lcom/hugh/category/data/repository/RemoteDataSource;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/hugh/category/data/repository/RemoteDataSource;)V", "getEverything", "Lcom/hugh/category/domain/state/ArticleState;", "type", "", "from", "to", "page", "", "pageSize", "sortType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "category_debug"})
public final class ArticleRepositoryImpl implements com.hugh.category.domain.repository.ArticleRepository {
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final com.hugh.category.data.repository.RemoteDataSource remoteDataSource = null;
    
    @javax.inject.Inject
    public ArticleRepositoryImpl(@org.jetbrains.annotations.NotNull
    @com.hugh.coroutine.IoDispatcher
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    com.hugh.category.data.repository.RemoteDataSource remoteDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getEverything(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String from, @org.jetbrains.annotations.Nullable
    java.lang.String to, int page, int pageSize, @org.jetbrains.annotations.NotNull
    java.lang.String sortType, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.hugh.category.domain.state.ArticleState> continuation) {
        return null;
    }
}