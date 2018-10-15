package com.ahasanidea.kotlin.roomdatabase.model

import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

data class Author(@PrimaryKey(autoGenerate = true) var authorId:Int?=null, var name:String, var address:String):Serializable