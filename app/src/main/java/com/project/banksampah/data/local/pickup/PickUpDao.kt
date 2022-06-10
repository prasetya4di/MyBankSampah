package com.project.banksampah.data.local.pickup

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.project.banksampah.model.entity.PickUp

@Dao
interface PickUpDao {
    @Query("SELECT * FROM pickup")
    fun getAll(): List<PickUp>

    @Query("SELECT * FROM pickup WHERE uid IN (:pickUpIds)")
    fun loadAllByIds(pickUpIds: IntArray): List<PickUp>

    @Query("SELECT * FROM pickup WHERE uid = :uid LIMIT 1")
    fun findById(uid: Int): PickUp

    @Insert
    fun insert(pickup: PickUp)

    @Delete
    fun delete(pickup: PickUp)
}
