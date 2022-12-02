package com.example.a4bb4g1.ui.activities

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.a4bb4g1.data.datasource.MemoryDataSource
import com.example.a4bb4g1.data.db.AppDatabase
import com.example.a4bb4g1.data.viewmodels.LoginViewModel
import com.example.a4bb4g1.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val db: AppDatabase by inject()
    private val memoryDataSource: MemoryDataSource by inject()
    private val scope = CoroutineScope(newSingleThreadContext("splash"))
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onStart(){
        super.onStart()
        scope.launch {
            if(db.doctorDao().getCount() == 0){
                db.doctorDao().insertAll(memoryDataSource.doctors())
            }
            if(db.serviceDao().getCount() == 0){
                db.serviceDao().insertAll(memoryDataSource.services())
            }
        }
        binding.splashAnimation.playAnimation()
        binding.splashAnimation.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                loginViewModel.currentUser()

            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationRepeat(p0: Animator?) {

            }

        })
        observeViewModel()
    }
    private fun observeViewModel(){
        loginViewModel.user.observe(this, Observer {
            if(it == null){
                val intent = Intent(applicationContext, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(applicationContext, HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        })
    }
}