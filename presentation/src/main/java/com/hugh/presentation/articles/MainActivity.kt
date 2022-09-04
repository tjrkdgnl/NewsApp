package com.hugh.presentation.articles

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hugh.presentation.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val articleViewModel: ArticleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        articleViewModel.getEveryThing("bitcoin")

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                articleViewModel.errorFlow.collectLatest {
                    Timber.e(it)
                }
            }
        }
    }
}