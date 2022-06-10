package com.project.banksampah.usecase

import com.project.banksampah.model.entity.PickUp

interface DeletePickUp {
    operator fun invoke(pickUp: PickUp)
}
