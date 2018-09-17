package com.ahasanidea.kotlin.roomdatabase.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * Created by Ahasan
 */
@Entity
class User(var name: String):Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    lateinit var personName: String
    lateinit var itemName: String

    constructor(name: String, item: String) : this(name) {
        personName = name
        itemName = item
    }


}