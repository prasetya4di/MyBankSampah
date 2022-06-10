package com.project.banksampah.usecase

import com.project.banksampah.model.entity.PickUp

interface RequestPickUp {
    operator fun invoke(pickUp: PickUp)
}
