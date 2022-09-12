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
import kotlinx.coroutines.*
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var navHost: NavHost

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBottomNavigationView()
        initToolbar()

        CoroutineScope(Dispatchers.Main).launch {
            val deferred = async {
                var data = 0
                delay(300)
                Timber.e("delay 이후 thread 점검 ${Thread.currentThread().name}")

                repeat(1000) {
                    if (data == 0) {
                        Timber.e("async thread 점검 ${Thread.currentThread().name}")
                    }
                    data += it + 1
                }
            }

            Timber.e("중간 스레드 점검 : ${Thread.currentThread().name}")

            deferred.await()

            launch {
                delay(100)

                Timber.e("launch thread 점검 ${Thread.currentThread().name}")
            }


            Timber.e("마지막 thread 점검 ${Thread.currentThread().name}")
        }

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