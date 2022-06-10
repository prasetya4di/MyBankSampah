package com.project.banksampah.usecase

import androidx.lifecycle.LiveData

interface GetTotalBalance {
    operator fun invoke(): LiveData<Int>
}
