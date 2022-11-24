package com.todokanai.roompractice.repository

import android.app.Application
import com.todokanai.roompractice.room.User
import com.todokanai.roompractice.room.UserDatabase

class UserRepository (application: Application) {

    private val db = UserDatabase.getInstance(application)
    fun getAll() = db.userDao().getAll()

    suspend fun insert(user : User){
        db.userDao().insert(user)
    }

    suspend fun delete(user : User){
        db.userDao().delete(user)
    }

    /*
    companion object {

        // For Singleton instantiation
        @Volatile private var instance: UserRepository? = null

        fun getInstance(application: Application) =
            instance ?: synchronized(this) {
                instance ?: UserRepository(application).also { instance = it }
            }
    }

     */
}