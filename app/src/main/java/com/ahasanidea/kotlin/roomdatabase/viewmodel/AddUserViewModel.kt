package com.ahasanidea.kotlin.roomdatabase.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.os.AsyncTask
import com.ahasanidea.kotlin.roomdatabase.data.UserDatabase
import com.ahasanidea.kotlin.roomdatabase.model.User

class AddUserViewModel(application: Application):AndroidViewModel(application) {
    private var appDatabase: UserDatabase? = null

    init {
        appDatabase = UserDatabase.getDatabase(getApplication())
    }

    fun addUser(user: User) {
        addAsyncTask(appDatabase!!).execute(user)
    }
    private class addAsyncTask constructor(private val appDatabase: UserDatabase) : AsyncTask<User, Void, Void>() {
        override fun doInBackground(vararg params: User): Void? {
            appDatabase.userDao().addUserModel(params[0])
            return null
        }
    }

    fun updateUser(user: User) {
        updateAsyncTask(appDatabase!!).execute(user)
    }

    private class updateAsyncTask constructor(val appDatabase: UserDatabase) : AsyncTask<User, Void, Void>() {
        override fun doInBackground(vararg user: User): Void? {
            //appDatabase.itemAndPersonModel().deleteUser(user[0])
            appDatabase.userDao().updateUser(user[0])
            return null
        }
    }

}