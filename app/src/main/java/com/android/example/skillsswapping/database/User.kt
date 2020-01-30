package com.android.example.skillsswapping.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User constructor(
    @PrimaryKey @ColumnInfo(name = "user_id") val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val password: String,
    @ColumnInfo val job: String,
    @ColumnInfo val about: String
)