package com.project.banksampah.repository

import com.project.banksampah.model.entity.PickUp

interface PickUpRepository {
    fun insert(pickUp: PickUp)
    fun delete(pickUp: PickUp)
    fun getAllPickUp(): List<PickUp>
}
