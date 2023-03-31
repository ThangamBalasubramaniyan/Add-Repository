package com.example.firstzoomtask

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RegisterDao {

    @Insert
    fun insert(register: RegisterEntity)

    @Query("SELECT * FROM Register_repos")
    fun getAllData(): List<RegisterEntity>

    @Query("DELETE FROM Register_repos")
    suspend fun deleteAll(): Int
}