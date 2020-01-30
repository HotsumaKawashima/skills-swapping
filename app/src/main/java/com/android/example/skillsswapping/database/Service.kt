package com.android.example.skillsswapping.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "service")
data class Service constructor(
    @PrimaryKey @ColumnInfo(name = "user_id") val id:Int,
    @ColumnInfo val category: String,
    @ColumnInfo val description: String,
    @ColumnInfo val how: String,
    @ColumnInfo val price: String
)