package com.example.a4bb4g1.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.a4bb4g1.data.models.DoctorItemModel


@Dao
interface DoctorDao {

    @Query("SELECT * FROM doctors")
    suspend fun getAll(): List<DoctorItemModel>

    @Query("SELECT * FROM doctors WHERE speciality = :speciality")
    suspend fun getAllBySpeciality(speciality: String): List<DoctorItemModel>

    @Query("SELECT COUNT(*) FROM doctors")
    suspend fun getCount(): Int

    @Insert
    suspend fun insertAll(doctors: List<DoctorItemModel>)
}