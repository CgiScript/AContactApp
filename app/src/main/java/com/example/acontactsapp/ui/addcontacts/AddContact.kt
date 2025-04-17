package com.example.acontactsapp.ui.addcontacts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.acontactsapp.model.UserDatabase
import com.example.acontactsapp.nav.AddContact
import com.example.acontactsapp.nav.Home

@Composable
fun AddContactPage(controller:NavController){
    val nameText = remember { mutableStateOf("") }
    val surnameText = remember { mutableStateOf("") }
    val emailText = remember { mutableStateOf("") }
    val phoneText = remember { mutableStateOf("") }

    val db = UserDatabase.getDatabase(LocalContext.current)
    val addContactViewModel = AddContactViewModel(db)

    Box(modifier = Modifier.fillMaxSize().background(color = Color.White)){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ){
            Text("Yeni Kişi Oluştur ", fontSize = 30.sp)
            Spacer(modifier = Modifier.size(40.dp))
            TextField(
                modifier = Modifier.padding(bottom = 20.dp),
                onValueChange = {nameText.value = it},
                value = nameText.value,
                leadingIcon = {Icon(imageVector = Icons.Default.AccountBox, contentDescription = "")},
                placeholder = { Text("İsim") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent
                )
            )
            TextField(
                modifier = Modifier.padding(bottom = 20.dp),
                onValueChange = {surnameText.value = it},
                value = surnameText.value,
                leadingIcon = {Icon(imageVector = Icons.Default.AccountBox, contentDescription = "")},
                placeholder = { Text("Soyisim") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent
                )
            )
            TextField(
                modifier = Modifier.padding(bottom = 20.dp),
                onValueChange = {emailText.value = it},
                value = emailText.value,
                leadingIcon = {Icon(imageVector = Icons.Default.Email, contentDescription = "")},
                placeholder = { Text("E-mail") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent
                )
            )
            TextField(
                modifier = Modifier.padding(bottom = 20.dp),
                onValueChange = {phoneText.value = it},
                value = phoneText.value,
                leadingIcon = {Icon(imageVector = Icons.Default.Call, contentDescription = "")},
                placeholder = { Text("Telefon") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent
                )
            )
            TextField(
                modifier = Modifier.padding(bottom = 20.dp),
                onValueChange = {},
                value = "",
                leadingIcon = {Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")},
                placeholder = { Text("Profil Fotoğrafı") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.size(40.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = {addContactViewModel.addUser(
                        name = nameText.value,
                        surname = surnameText.value,
                        email = emailText.value,
                        phone = phoneText.value
                    ); controller.navigate(Home)},
                    modifier = Modifier.size(50.dp)) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                }
                Spacer(modifier = Modifier.size(50.dp))
                IconButton(onClick = {controller.navigate(Home)},modifier = Modifier.size(50.dp)) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun AddContactPagePreview(){
//    AddContactPage()
//}