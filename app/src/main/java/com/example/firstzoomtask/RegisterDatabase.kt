package com.example.firstzoomtask

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RegisterEntity :: class], version = 1)
abstract class RegisterDatabase : RoomDatabase() {

    abstract val userDao : RegisterDao

    companion object{

        @Volatile
        private var INSTANCE : RegisterDatabase? = null

        fun getDatabase(context: Context): RegisterDatabase{

            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RegisterDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }

}