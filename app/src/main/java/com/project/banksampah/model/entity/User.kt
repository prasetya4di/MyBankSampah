package com.project.banksampah.model.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "user")
@Parcelize
class User(
    @PrimaryKey
    var uid: Int = 0,
    @ColumnInfo(name = "email")
    var email: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "phone")
    var phoneNumber: String,
    @ColumnInfo(name = "photo_url")
    var photoUrl: String,
) : Parcelable
