package com.example.firstzoomtask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Register_repos")
data class RegisterEntity(

    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "owner_name")
    var ownerName: String,

    @ColumnInfo(name = "repo_name")
    var repoName: String
)
