package com.project.banksampah.usecase

import com.project.banksampah.model.entity.PickUp

interface RequestPickUp {
    fun invoke(pickUp: PickUp)
}
