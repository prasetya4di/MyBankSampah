package com.project.banksampah.usecase

import com.project.banksampah.model.entity.PickUp

interface GetAllPickUp {
    fun invoke(): List<PickUp>
}
