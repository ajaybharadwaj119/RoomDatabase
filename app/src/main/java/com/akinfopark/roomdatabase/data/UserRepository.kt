package com.akinfopark.roomdatabase.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDeo: UserDao) {

    val readAllData: LiveData<List<User>> = userDeo.readAllData()

    suspend fun addUser(user: User){
        userDeo.addUser(user)
    }

}