package com.project.banksampah.usecase

import com.project.banksampah.model.entity.PickUp

interface GetAllPickUp {
    operator fun invoke(): List<PickUp>
}
