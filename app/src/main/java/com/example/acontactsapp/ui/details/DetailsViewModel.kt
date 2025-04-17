package com.example.acontactsapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acontactsapp.model.UserDatabase
import com.example.acontactsapp.model.UserEntity
import com.example.acontactsapp.model.db
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(private val db:UserDatabase): ViewModel(){

    fun deleteUser(phonenumber:String){
        viewModelScope.launch {
            db.userDao().delete(phonenumber)
        }
    }
}