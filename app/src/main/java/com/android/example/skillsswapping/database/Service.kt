package com.android.example.skillsswapping.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "service")
data class Post constructor(
    @PrimaryKey @ColumnInfo(name = "user_id") val id:Int,
    @ColumnInfo val category: String,
    @ColumnInfo val description: String
)