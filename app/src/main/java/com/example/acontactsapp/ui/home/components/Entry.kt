package com.example.acontactsapp.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Entry(
    name:String, surname:String, email:String, number: String,
    openDetailScreen: ()->Unit
){
    Row(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .size(120.dp)
    ) {
        Portrait(name)
        Spacer(modifier = Modifier.size(15.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                .weight(0.5f)
                .fillMaxWidth()
            ){
                TextButton(
                    onClick = {openDetailScreen()},
                    modifier = Modifier
                    .fillMaxWidth()
                    .background(color=Color(35, 36, 40))
                ) {
                    Text("$name $surname",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start)
                }
            }
            Row(modifier = Modifier
                .weight(0.25f)
                .fillMaxWidth()
            ){
                Text(email, fontSize = 12.sp)
            }
            Row(modifier = Modifier
                .weight(0.25f)
                .fillMaxWidth()
            ){
                Text(number, fontSize = 12.sp)
            }
        }
    }
}


//@Preview
//@Composable
//fun EntryPreview(){
//    Entry()
//}