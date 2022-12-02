package com.example.a4bb4g1.di

import com.example.a4bb4g1.data.repositories.HomeRepository
import com.example.a4bb4g1.data.repositories.LoginRepository
import org.koin.dsl.module

val repoModule = module{
    single { LoginRepository(get(), get(), get()) }
    single { HomeRepository(get(), get(), get(), get(), get()) }
}