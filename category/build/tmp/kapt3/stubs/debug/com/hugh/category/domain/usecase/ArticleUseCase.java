package com.hugh.category.domain.usecase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/hugh/category/domain/usecase/ArticleUseCase;", "", "getEveryThing", "Lcom/hugh/category/domain/state/ArticleState;", "type", "", "from", "to", "sortType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "category_debug"})
public abstract interface ArticleUseCase {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getEveryThing(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String from, @org.jetbrains.annotations.Nullable
    java.lang.String to, @org.jetbrains.annotations.NotNull
    java.lang.String sortType, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.hugh.category.domain.state.ArticleState> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}