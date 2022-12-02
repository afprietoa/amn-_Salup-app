package com.example.a4bb4g1.di

import androidx.room.Room
import com.example.a4bb4g1.data.datasource.MemoryDataSource
import com.example.a4bb4g1.data.db.AppDatabase
import com.example.a4bb4g1.data.db.dao.DoctorDao
import com.example.a4bb4g1.data.db.dao.ServiceDao
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataSourceModule = module {
    single { MemoryDataSource() }
    single<AppDatabase> { Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "dbmintic").build()}
    single<DoctorDao> {get<AppDatabase>().doctorDao()}
    single<ServiceDao> {get<AppDatabase>().serviceDao()}
    single {Firebase.auth}
    single {Firebase.firestore}
    single {Firebase.storage("gs://mintic4b1-b3-2d4d5.appspot.com")}
}