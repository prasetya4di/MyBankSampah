package com.project.banksampah.repository.impl

import androidx.lifecycle.LiveData
import com.project.banksampah.data.local.user.UserDao
import com.project.banksampah.model.entity.User
import com.project.banksampah.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override fun login(user: User) {
        TODO("Not yet implemented")
    }

    override fun register(user: User) {
        TODO("Not yet implemented")
    }

    override fun getUser(): LiveData<User> = userDao.getUser()
}
