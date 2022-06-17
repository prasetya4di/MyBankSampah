package com.project.banksampah.data.local.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.project.banksampah.model.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM user LIMIT 1")
    fun findById(uid: Int): LiveData<User>

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}
