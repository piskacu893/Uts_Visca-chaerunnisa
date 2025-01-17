package com.example.pnjutstivisca_chaerunnisa.data.Entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pnjutstivisca_chaerunnisa.data.dao.UserDao
import com.example.pnjutstivisca_chaerunnisa.data.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance!!
        }
    }
}