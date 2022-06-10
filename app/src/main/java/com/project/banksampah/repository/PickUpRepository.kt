package com.project.banksampah.repository

import com.project.banksampah.data.local.pickup.PickUpDao
import com.project.banksampah.model.entity.PickUp
import javax.inject.Inject

class PickUpRepository @Inject constructor(
    private val pickUpDao: PickUpDao
) {
    fun insert(pickUp: PickUp) {
        pickUpDao.insert(pickUp)
    }

    fun delete(pickUp: PickUp) {
        pickUpDao.delete(pickUp)
    }

    fun getAllPickUp(): List<PickUp> = pickUpDao.getAll()
}
