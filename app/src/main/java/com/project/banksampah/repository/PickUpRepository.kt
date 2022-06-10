package com.project.banksampah.repository

import androidx.lifecycle.LiveData
import com.project.banksampah.model.entity.PickUp

interface PickUpRepository {
    fun insert(pickUp: PickUp)
    fun delete(pickUp: PickUp)
    fun getAllPickUp(): LiveData<List<PickUp>>
    fun getTotalBalance(): LiveData<Int>
}
