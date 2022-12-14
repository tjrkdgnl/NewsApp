package com.hugh.wantedpreonboarding

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hugh.base.BaseActivity
import com.hugh.wantedpreonboarding.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

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
}