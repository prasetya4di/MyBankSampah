package com.project.banksampah.usecase.impl

import com.project.banksampah.model.entity.PickUp
import com.project.banksampah.repository.PickUpRepository
import com.project.banksampah.usecase.DeletePickUp
import javax.inject.Inject

class DeletePickUpImpl @Inject constructor(
    private val pickUpRepository: PickUpRepository
) : DeletePickUp {
    override fun invoke(pickUp: PickUp) {
        pickUpRepository.delete(pickUp)
    }
}
