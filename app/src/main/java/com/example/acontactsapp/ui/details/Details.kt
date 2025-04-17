package com.example.acontactsapp.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.acontactsapp.model.UserDatabase
import com.example.acontactsapp.ui.home.HomeViewModel

@Composable
fun ProfileDialog(
    onDismiss : ()->Unit,
    name:String, surname:String,
    phone:String,
    deleteUser:()->Unit
){

    Dialog(onDismissRequest = onDismiss) {
        Card(modifier = Modifier
            .size(400.dp)
            .background(color = Color.Transparent)
            .padding(20.dp),

        ){
            Column(modifier = Modifier
                .fillMaxHeight().background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(modifier = Modifier
                        .size(160.dp)
                        .clip(RoundedCornerShape(45.dp))
                        .background(color = Color.LightGray)
                        .fillMaxWidth()
                ){

                }
                Spacer(modifier = Modifier.size(20.dp))
                Text("$name $surname",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp)
                Spacer(modifier = Modifier.size(30.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    IconButton(onClick = {}, modifier = Modifier.size(40.dp)) { Icon(modifier = Modifier.size(40.dp), imageVector = Icons.Default.Call, contentDescription = "") }
                    Spacer(modifier = Modifier.size(20.dp))
                    IconButton(onClick = {}, modifier = Modifier.size(40.dp)) { Icon(modifier = Modifier.size(40.dp), imageVector = Icons.Default.Email, contentDescription = "") }
                    Spacer(modifier = Modifier.size(20.dp))
                    IconButton(onClick = {}, modifier = Modifier.size(40.dp)) { Icon(modifier = Modifier.size(40.dp), imageVector = Icons.Default.Edit, contentDescription = "") }
                    Spacer(modifier = Modifier.size(20.dp))
                    IconButton(onClick = {deleteUser(); onDismiss()}, modifier = Modifier.size(40.dp)) { Icon(modifier = Modifier.size(40.dp), imageVector = Icons.Default.Delete, contentDescription = "") }
                }
                Spacer(modifier = Modifier.size(10.dp))
                Text("Phone: $phone", fontSize = 14.sp)
                Spacer(modifier = Modifier.size(10.dp))

            }
        }
    }

}



//@Composable
//fun DetailPage(){
//    val openAlertDialog = remember { mutableStateOf(false) }
//
//    Column(modifier = Modifier.fillMaxSize().background(color = Color.White)){
//        Button(onClick = { openAlertDialog.value = true }) { Text("KİŞİLER") }
//        if (openAlertDialog.value){
//            ProfileDialog(onDismiss = {openAlertDialog.value = false})
//        }
//    }
//
//}



//@Preview
//@Composable
//fun DetailPagePreview(){
//    DetailPage()
//}