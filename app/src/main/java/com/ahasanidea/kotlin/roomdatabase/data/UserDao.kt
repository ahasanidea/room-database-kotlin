package com.ahasanidea.kotlin.roomdatabase.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.ahasanidea.kotlin.roomdatabase.model.User

@Dao
interface UserDao {

    @Query("select * from User")
    fun getAllUsers(): LiveData<List<User>>

    @Query("select * from User where id = :id")
    fun getItemById(id: String): User

    @Insert(onConflict = REPLACE)
    fun addUserModel(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Insert
    fun insertAll(vararg users: User)

    @Query("delete from User")
    fun deleteAll()
}