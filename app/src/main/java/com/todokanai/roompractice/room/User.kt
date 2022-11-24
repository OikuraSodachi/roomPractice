package com.todokanai.roompractice.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_user")
data class User(
    @ColumnInfo val number : Long?
) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo
    var no : Long? = null
    override fun toString(): String {
        return "User(number=$number)"
    }
}