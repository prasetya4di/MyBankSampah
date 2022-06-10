package com.project.banksampah.usecase.impl

import androidx.lifecycle.LiveData
import com.project.banksampah.model.entity.PickUp
import com.project.banksampah.repository.PickUpRepository
import com.project.banksampah.usecase.GetAllPickUp
import javax.inject.Inject

class GetAllPickUpImpl @Inject constructor(
    private val pickUpRepository: PickUpRepository
) : GetAllPickUp {
    override operator fun invoke(): LiveData<List<PickUp>> = pickUpRepository.getAllPickUp()
}
