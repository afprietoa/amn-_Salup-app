package com.example.a4bb4g1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a4bb4g1.databinding.ActivityLoginBinding
import com.example.a4bb4g1.databinding.ActivitySplashBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}