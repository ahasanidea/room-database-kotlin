package com.ahasanidea.kotlin.roomdatabase.model

import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

data class Book(@PrimaryKey(autoGenerate = true) var bookId:Int?=null, var title:String, var isbn:String) :Serializable