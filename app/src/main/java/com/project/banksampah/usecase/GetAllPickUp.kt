package com.project.banksampah.usecase

import androidx.lifecycle.LiveData
import com.project.banksampah.model.entity.PickUp

interface GetAllPickUp {
    operator fun invoke(): LiveData<List<PickUp>>
}
