package com.example.a4bb4g1

import android.app.Application
import com.example.a4bb4g1.di.dataSourceModule
import com.example.a4bb4g1.di.repoModule
import com.example.a4bb4g1.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MinticApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MinticApp)
            modules(listOf(dataSourceModule, repoModule, viewmodelModule))
        }
    }
}