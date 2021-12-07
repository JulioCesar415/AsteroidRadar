package com.udacity.asteroidradar.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// abstract class that extends RoomDatabase
@Database(entities = [DatabaseEntities::class], version = 1, exportSchema = false)
abstract class AsteroidDatabase : RoomDatabase(){
//    abstract val that returns AsteroidDatbaseDao
    abstract val asteroidDatabaseDao: AsteroidDatabaseDao

//    companion object
    companion object{
        @Volatile
        private var INSTANCE: AsteroidDatabase? = null

//        method will return reference to AsteroidDatabase
        fun getInstance(context: Context): AsteroidDatabase{

            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AsteroidDatabase::class.java,
                        "asteroid_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}