package com.project.banksampah.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.banksampah.data.local.pickup.PickUpDao
import com.project.banksampah.model.entity.PickUp

@Database(entities = [PickUp::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pickUpDao(): PickUpDao
}
