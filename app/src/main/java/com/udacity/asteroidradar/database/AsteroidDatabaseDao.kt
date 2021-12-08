package com.udacity.asteroidradar.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.udacity.asteroidradar.Asteroid

@Dao
interface AsteroidDatabaseDao{

    @Query("SELECT * FROM asteroid_detail_table ORDER BY close_approach_date DESC")
    fun getAsteroids(): LiveData<List<DatabaseEntities>>

    @Query("SELECT * FROM asteroid_detail_table WHERE close_approach_date = :startDate ORDER BY close_approach_date DESC")
    fun getAsteroidsDay(startDate: String): LiveData<List<DatabaseEntities>>

    @Query("SELECT * FROM asteroid_detail_table WHERE close_approach_date BETWEEN :startDate AND :endDate ORDER BY close_approach_date DESC")
    fun getAsteroidsDate(startDate: String, endDate: String): LiveData<List<DatabaseEntities>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg asteroid: DatabaseEntities)
}