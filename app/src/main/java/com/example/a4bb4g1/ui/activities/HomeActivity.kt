package com.example.a4bb4g1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.a4bb4g1.R
import com.example.a4bb4g1.data.viewmodels.LoginViewModel
import com.example.a4bb4g1.databinding.ActivityHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityHomeToolbar.title=""
        setSupportActionBar(binding.activityHomeToolbar)
    }

    override fun onStart() {
        super.onStart()
        binding.activityHomeToolbarImage.setOnClickListener{

        }
        loginViewModel.currentUser()
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.locationFragment,
            R.id.specialistFragment,
            R.id.profileFragment
        ))

        val navController = findNavController(R.id.nav_host_home_fragment)
        binding.activityHomeButtonNavigation.setupWithNavController(navController)
        binding.activityHomeToolbar.setupWithNavController(navController, appBarConfiguration)

    }
}