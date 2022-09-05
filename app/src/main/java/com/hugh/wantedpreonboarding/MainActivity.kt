package com.hugh.wantedpreonboarding

import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.hugh.base.BaseActivity
import com.hugh.wantedpreonboarding.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    NavigationBarView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNavigation()
        initToolbar()
    }

    private fun setUpNavigation() {
        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.bottomNavi.setupWithNavController(navHost.navController)

        binding.bottomNavi.setOnItemSelectedListener(this)
    }

    private fun initToolbar() {
        setToolbarTitle(binding.bottomNavi.selectedItemId)
        setSupportActionBar(binding.toolbar)

        binding.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_700))
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setToolbarTitle(id: Int) {
        when (id) {
            R.id.headLine -> {
                binding.toolbar.title = getString(R.string.head_line)
            }
            R.id.category -> {
                binding.toolbar.title = getString(R.string.category)
            }
            R.id.bookmark -> {
                binding.toolbar.title = getString(R.string.bookmark)
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.headLine -> {
                setToolbarTitle(R.id.headLine)
            }
            R.id.category -> {
                setToolbarTitle(R.id.category)
            }
            R.id.bookmark -> {
                setToolbarTitle(R.id.bookmark)
            }
        }

        return true
    }
}