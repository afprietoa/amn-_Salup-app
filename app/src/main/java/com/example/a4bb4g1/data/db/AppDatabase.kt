package com.example.a4bb4g1.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a4bb4g1.data.db.dao.DoctorDao
import com.example.a4bb4g1.data.db.dao.ServiceDao
import com.example.a4bb4g1.data.models.DoctorItemModel
import com.example.a4bb4g1.data.models.ServiceItemModel

@Database(entities = [DoctorItemModel::class, ServiceItemModel::class], version = 1 )
abstract class AppDatabase: RoomDatabase() {
    abstract fun serviceDao(): ServiceDao
    abstract fun doctorDao(): DoctorDao
}