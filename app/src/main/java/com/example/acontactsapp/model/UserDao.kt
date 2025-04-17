package com.example.acontactsapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao{
    @Insert
    suspend fun insert(msg:UserEntity)

    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("DELETE FROM User WHERE phone = :phonenumber")
    suspend fun delete(phonenumber:String)
}