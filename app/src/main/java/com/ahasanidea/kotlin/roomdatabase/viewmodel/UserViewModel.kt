package com.ahasanidea.kotlin.roomdatabase.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.ahasanidea.kotlin.roomdatabase.data.UserDatabase
import com.ahasanidea.kotlin.roomdatabase.data.UserRepository
import com.ahasanidea.kotlin.roomdatabase.model.User

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private var userRepository: UserRepository? = null
    private var users: LiveData<List<User>>? = null

    init {
        userRepository = UserRepository(application)
        users = userRepository!!.getAllUsers()
    }
    fun getAllUsers(): LiveData<List<User>> {
        return users!!
    }
    fun deleteItem(user: User) {
        userRepository!!.deleteItem(user)
    }


}