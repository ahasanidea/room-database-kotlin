package com.ahasanidea.kotlin.roomdatabase.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.ahasanidea.kotlin.roomdatabase.data.UserDatabase
import com.ahasanidea.kotlin.roomdatabase.model.User

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private var userDatabase: UserDatabase? = null
    private var users: LiveData<List<User>>? = null

    init {
        userDatabase = UserDatabase.getDatabase(application)
        users = userDatabase!!.userDao().getAllUsers()
    }
    fun getAllUsers(): LiveData<List<User>> {
        return users!!
    }
    fun deleteItem(user: User) {
        deleteAsyncTask(userDatabase!!).execute(user)
    }
    private class deleteAsyncTask internal constructor(private val db: UserDatabase) : AsyncTask<User, Void, Void>() {
        override fun doInBackground(vararg params: User): Void? {
            db.userDao().deleteUser(params[0])
            return null
        }
    }

}