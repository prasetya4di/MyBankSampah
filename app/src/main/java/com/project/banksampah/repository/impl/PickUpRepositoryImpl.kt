package com.project.banksampah.repository.impl

import androidx.lifecycle.LiveData
import com.project.banksampah.data.local.pickup.PickUpDao
import com.project.banksampah.model.entity.PickUp
import com.project.banksampah.repository.PickUpRepository
import javax.inject.Inject

class PickUpRepositoryImpl @Inject constructor(
    private val pickUpDao: PickUpDao
) : PickUpRepository {
    override fun insert(pickUp: PickUp) {
        pickUpDao.insert(pickUp)
    }

    override fun delete(pickUp: PickUp) {
        pickUpDao.delete(pickUp)
    }

    override fun getAllPickUp(): LiveData<List<PickUp>> = pickUpDao.getAll()

    override fun getTotalBalance(): LiveData<Int> = pickUpDao.getTotalBalance()
}
