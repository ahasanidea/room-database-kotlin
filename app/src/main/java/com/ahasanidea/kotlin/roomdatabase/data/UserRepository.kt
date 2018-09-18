package com.ahasanidea.kotlin.roomdatabase.data

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.ahasanidea.kotlin.roomdatabase.model.User

class UserRepository(application: Application) {
    private var userDao:UserDao?=null
    init {
      userDao=UserDatabase.getDatabase(application).userDao()
    }
    fun getAllUsers(): LiveData<List<User>> {
        return userDao!!.getAllUsers()
    }
    fun addUser(user: User) {
        addAsyncTask(userDao!!).execute(user)
    }
    private class addAsyncTask constructor(private val dao: UserDao) : AsyncTask<User, Void, Void>() {
        override fun doInBackground(vararg params: User): Void? {
            dao.addUserModel(params[0])
            return null
        }
    }

    fun updateUser(user: User) {
        updateAsyncTask(userDao!!).execute(user)
    }

    private class updateAsyncTask constructor(val dao: UserDao) : AsyncTask<User, Void, Void>() {
        override fun doInBackground(vararg user: User): Void? {
            //appDatabase.itemAndPersonModel().deleteUser(user[0])
            dao.updateUser(user[0])
            return null
        }
    }
    fun deleteItem(user: User) {
        deleteAsyncTask(userDao!!).execute(user)
    }
    private class deleteAsyncTask internal constructor(private val dao: UserDao) : AsyncTask<User, Void, Void>() {
        override fun doInBackground(vararg params: User): Void? {
            dao.deleteUser(params[0])
            return null
        }
    }
}