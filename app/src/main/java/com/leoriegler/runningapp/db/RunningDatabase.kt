package com.leoriegler.runningapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.leoriegler.runningapp.models.Run

@Database(
    entities = [Run::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RunningDatabase : RoomDatabase(){

    abstract fun getRunDao(): RunDao
}