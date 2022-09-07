package com.hugh.category.data.usecase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/hugh/category/data/usecase/ArticleUseCaseImpl;", "Lcom/hugh/category/domain/usecase/ArticleUseCase;", "articleRepository", "Lcom/hugh/category/domain/repository/ArticleRepository;", "(Lcom/hugh/category/domain/repository/ArticleRepository;)V", "getEveryThing", "Lcom/hugh/category/domain/state/ArticleState;", "type", "", "from", "to", "sortType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "category_debug"})
public final class ArticleUseCaseImpl implements com.hugh.category.domain.usecase.ArticleUseCase {
    private final com.hugh.category.domain.repository.ArticleRepository articleRepository = null;
    
    @javax.inject.Inject
    public ArticleUseCaseImpl(@org.jetbrains.annotations.NotNull
    com.hugh.category.domain.repository.ArticleRepository articleRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getEveryThing(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String from, @org.jetbrains.annotations.Nullable
    java.lang.String to, @org.jetbrains.annotations.NotNull
    java.lang.String sortType, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.hugh.category.domain.state.ArticleState> continuation) {
        return null;
    }
}