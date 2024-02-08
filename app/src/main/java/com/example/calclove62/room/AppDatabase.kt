package com.example.calclove62.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calclove62.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

  abstract fun loveDao(): LoveDao
}