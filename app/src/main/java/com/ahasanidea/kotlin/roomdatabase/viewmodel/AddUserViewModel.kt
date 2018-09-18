package com.ahasanidea.kotlin.roomdatabase.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.os.AsyncTask
import com.ahasanidea.kotlin.roomdatabase.data.UserDatabase
import com.ahasanidea.kotlin.roomdatabase.data.UserRepository
import com.ahasanidea.kotlin.roomdatabase.model.User

class AddUserViewModel(application: Application):AndroidViewModel(application) {
    private var userRepository: UserRepository? = null

    init {
        userRepository = UserRepository(application)
    }

    fun addUser(user: User) {
        userRepository!!.addUser(user)
    }


    fun updateUser(user: User) {
        userRepository!!.updateUser(user)
    }



}