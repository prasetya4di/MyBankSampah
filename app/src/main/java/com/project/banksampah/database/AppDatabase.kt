package com.project.banksampah.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.banksampah.data.local.pickup.PickUpDao
import com.project.banksampah.data.local.user.UserDao
import com.project.banksampah.model.entity.PickUp
import com.project.banksampah.util.Converters

@Database(entities = [PickUp::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pickUpDao(): PickUpDao
    abstract fun userDao(): UserDao
}
