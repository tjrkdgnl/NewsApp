package com.hugh.category.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JI\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/hugh/category/domain/repository/ArticleRepository;", "", "getEverything", "Lcom/hugh/category/domain/state/ArticleState;", "type", "", "from", "to", "page", "", "pageSize", "sortType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "category_debug"})
public abstract interface ArticleRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getEverything(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String from, @org.jetbrains.annotations.Nullable
    java.lang.String to, int page, int pageSize, @org.jetbrains.annotations.NotNull
    java.lang.String sortType, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.hugh.category.domain.state.ArticleState> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}