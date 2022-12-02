package com.example.a4bb4g1.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "services")
data class ServiceItemModel (
    @PrimaryKey var id: String = "",
    var title: String = "",
    var description: String = "",
    var icon: String = ""
)
