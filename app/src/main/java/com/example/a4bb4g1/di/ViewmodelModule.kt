package com.example.a4bb4g1.di

import com.example.a4bb4g1.data.viewmodels.HomeViewModel
import com.example.a4bb4g1.data.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        HomeViewModel(get())
    }
}