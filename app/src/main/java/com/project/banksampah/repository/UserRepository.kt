package com.project.banksampah.repository

import androidx.lifecycle.LiveData
import com.project.banksampah.model.entity.User

interface UserRepository {
    fun login(user: User)
    fun register(user: User)
    fun getUser(): LiveData<User>
}
