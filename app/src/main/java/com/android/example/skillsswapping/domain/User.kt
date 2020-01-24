package com.android.example.skillsswapping.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var userid: Long,

    @ColumnInfo(name = "user_name")
    var username: String,

    @ColumnInfo(name = "user_password")
    var password: String)