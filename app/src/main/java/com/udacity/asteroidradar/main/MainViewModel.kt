package com.udacity.asteroidradar.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.udacity.asteroidradar.database.AsteroidDatabaseDao

//ViewModel is a class that is responsible for preparing and managing the data for
//an Activity or Fragment.
//ViewModel also handles the communication of the Activity/Fragment with the rest of
//the application
class MainViewModel(
    val database: AsteroidDatabaseDao, application: Application) : AndroidViewModel(application) {

//    define asteroids, then getAllAsteroids() from database DAO
    val asteroids = database.getAsteroids()
}