package com.ahasanidea.kotlin.roomdatabase.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * Created by Ahasan on 08/10/2018
 */

//@Parcelize
@Entity
data class User(@PrimaryKey(autoGenerate = true) var id:Int?=null, var name:String, var address:String): Serializable