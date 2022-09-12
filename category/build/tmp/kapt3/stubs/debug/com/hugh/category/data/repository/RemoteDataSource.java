package com.hugh.category.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JE\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/hugh/category/data/repository/RemoteDataSource;", "", "apiService", "Lcom/hugh/category/data/network/CategoryApiService;", "(Lcom/hugh/category/data/network/CategoryApiService;)V", "getEverything", "Lcom/hugh/category/domain/state/ArticleState;", "type", "", "from", "to", "page", "", "pageSize", "sortType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "category_debug"})
public final class RemoteDataSource {
    private final com.hugh.category.data.network.CategoryApiService apiService = null;
    
    @javax.inject.Inject
    public RemoteDataSource(@org.jetbrains.annotations.NotNull
    com.hugh.category.data.network.CategoryApiService apiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getEverything(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String from, @org.jetbrains.annotations.Nullable
    java.lang.String to, int page, int pageSize, @org.jetbrains.annotations.NotNull
    java.lang.String sortType, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.hugh.category.domain.state.ArticleState> continuation) {
        return null;
    }
}