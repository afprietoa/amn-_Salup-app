package com.example.a4bb4g1.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doctors")
data class DoctorItemModel (
    @PrimaryKey var id: String = "",
    var name: String = "",
    var speciality: String = "",
    var caption: String = "",
    var image: String = "",
    var star: Double = 0.0,
    var description: String = ""
    )