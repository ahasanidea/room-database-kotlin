package com.ahasanidea.kotlin.roomdatabase.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.ahasanidea.kotlin.roomdatabase.model.User

@Database(entities = [User::class],version = 1)
 abstract class UserDatabase :RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_db").build()
            }
            return INSTANCE as UserDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}