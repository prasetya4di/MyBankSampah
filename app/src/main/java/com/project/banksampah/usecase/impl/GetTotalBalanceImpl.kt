package com.project.banksampah.usecase.impl

import androidx.lifecycle.LiveData
import com.project.banksampah.repository.PickUpRepository
import com.project.banksampah.usecase.GetTotalBalance
import javax.inject.Inject

class GetTotalBalanceImpl @Inject constructor(
    private val pickUpRepository: PickUpRepository
) : GetTotalBalance {
    override fun invoke(): LiveData<Int> = pickUpRepository.getTotalBalance()
}
