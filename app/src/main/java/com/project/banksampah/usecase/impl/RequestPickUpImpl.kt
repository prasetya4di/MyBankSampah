package com.project.banksampah.usecase.impl

import com.project.banksampah.model.entity.PickUp
import com.project.banksampah.repository.PickUpRepository
import com.project.banksampah.usecase.RequestPickUp
import javax.inject.Inject

class RequestPickUpImpl @Inject constructor(private val pickUpRepository: PickUpRepository) :
    RequestPickUp {
    override operator fun invoke(pickUp: PickUp) {
        pickUpRepository.insert(pickUp)
    }
}
