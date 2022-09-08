package com.hugh.wantedpreonboarding

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hugh.CategoryType
import com.hugh.base.BaseActivity
import com.hugh.bookmark.presentation.BookmarkFragmentDirections
import com.hugh.callback.FragmentNavigator
import com.hugh.category.presentation.category.CategoryFragmentDirections
import com.hugh.category.presentation.categoryList.CategoryListFragmentDirections
import com.hugh.entity.ArticleEntity
import com.hugh.wantedpreonboarding.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main), FragmentNavigator {

    private lateinit var navHost: NavHost

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBottomNavigationView()
        initToolbar()
    }

    private fun setUpBottomNavigationView() {
        navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.bottomNavi.setupWithNavController(navHost.navController)
    }

    private fun initToolbar() {
        binding.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_700))
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navHost.navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navHost.navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun categoryListToCategoryDetail(articleEntity: ArticleEntity) {
        val action = CategoryListFragmentDirections.actionCategoryListToCategoryDetail(articleEntity)
        navHost.navController.navigate(action)
    }

    override fun bookmarkToCategoryDetail(articleEntity: ArticleEntity) {
        val action = BookmarkFragmentDirections.actionBookmarkToCategoryDetail(articleEntity)
        navHost.navController.navigate(action)
    }

    override fun categoryToCategoryList(categoryType: CategoryType) {
        val action = CategoryFragmentDirections.actionCategoryToCategoryList(categoryType)
        navHost.navController.navigate(action)
    }
}