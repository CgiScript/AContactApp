package com.example.acontactsapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acontactsapp.model.UserDatabase
import com.example.acontactsapp.model.UserEntity
import com.example.acontactsapp.model.db
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val db:UserDatabase): ViewModel(){
    var userList = MutableStateFlow<List<UserEntity>>(listOf())

    init{
            getAllUsers()
    }

    fun getAllUsers(){
        viewModelScope.launch {
            userList.value = db.userDao().getAllUsers()
        }
    }

    fun deleteUser(phonenumber:String){
        viewModelScope.launch {
            db.userDao().delete(phonenumber)
            getAllUsers()
        }


    }
}