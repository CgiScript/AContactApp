package com.example.acontactsapp.ui.addcontacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acontactsapp.model.UserDatabase
import com.example.acontactsapp.model.UserEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AddContactViewModel(private val db: UserDatabase): ViewModel(){

    fun addUser(name:String, surname:String, email:String, phone:String){
        viewModelScope.launch {
            db.userDao().insert(
                UserEntity(
                    name =  name,
                    surname = surname,
                    email = email,
                    phone = phone)
            )
        }

    }
}