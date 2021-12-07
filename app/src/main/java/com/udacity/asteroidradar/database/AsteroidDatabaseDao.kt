package com.udacity.asteroidradar.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.udacity.asteroidradar.Asteroid

@Dao
interface AsteroidDatabaseDao{
//    suspend fun inserts asteroid
//    @Insert
//    suspend fun insert(asteroid: DatabaseEntities)
//
////    suspend fun updates asteroid
//    @Update
//    suspend fun update(asteroid: DatabaseEntities)
//
////    suspend fun gets primary key from asteroid table
//    @Query("SELECT * from asteroid_detail_table WHERE id = :key")
//    suspend fun get(key: Long): DatabaseEntities?
//
////    suspend fun clears from asteroid_detail_table
//    @Query("DELETE FROM asteroid_detail_table")
//    suspend fun clear()
//
//    suspend fun gets all asteroids in descending order
    @Query("SELECT * FROM asteroid_detail_table ORDER BY id DESC")
    fun getAllAsteroids(): LiveData<List<DatabaseEntities>>
//
////    suspend fun gets current asteroid in descending order just one
//    @Query("SELECT * FROM asteroid_detail_table ORDER BY id DESC LIMIT 1")
//    suspend fun getAsteroid(): DatabaseEntities?
//
////    suspend fun gets asteroid with id
//    @Query("SELECT * from asteroid_detail_table WHERE id = :key")
//    fun getAsteroidWithId(key: Long): LiveData<DatabaseEntities>

}