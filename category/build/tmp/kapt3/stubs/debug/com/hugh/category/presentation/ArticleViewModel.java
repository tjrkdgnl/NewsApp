package com.hugh.category.presentation;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/hugh/category/presentation/ArticleViewModel;", "Landroidx/lifecycle/ViewModel;", "articleUseCase", "Lcom/hugh/category/domain/usecase/ArticleUseCase;", "(Lcom/hugh/category/domain/usecase/ArticleUseCase;)V", "errorFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getErrorFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "getEveryThing", "", "type", "", "category_debug"})
public final class ArticleViewModel extends androidx.lifecycle.ViewModel {
    private final com.hugh.category.domain.usecase.ArticleUseCase articleUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<java.lang.Throwable> errorFlow = null;
    
    @javax.inject.Inject
    public ArticleViewModel(@org.jetbrains.annotations.NotNull
    com.hugh.category.domain.usecase.ArticleUseCase articleUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableSharedFlow<java.lang.Throwable> getErrorFlow() {
        return null;
    }
    
    public final void getEveryThing(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
    }
}