package com.ahasanidea.kotlin.roomdatabase.model

import android.arch.persistence.room.PrimaryKey
import java.io.Serializable
import java.util.*

data class Rent(@PrimaryKey(autoGenerate = true) var rentId:Int?=null,var rentDate:Date,var expireDate: Date) :Serializable