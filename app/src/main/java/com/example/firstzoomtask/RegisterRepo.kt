package com.example.firstzoomtask

class RegisterRepo(private val dao: RegisterDao) {

    val data = dao.getAllData()

    fun insert(data: RegisterEntity) {
        return dao.insert(data)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAll()
    }
}