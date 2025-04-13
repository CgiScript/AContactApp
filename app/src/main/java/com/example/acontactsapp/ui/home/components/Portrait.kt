package com.example.acontactsapp.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Portrait(name:String){
    Box(modifier = Modifier
        .background(color = Color.White)
        .border(1.5.dp, Color.Black)
        .padding(2.dp)
        .size(100.dp)
    ){
        Column(modifier = Modifier.align(Alignment.Center)){
            Box(modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(color = Color.LightGray),
            ) {  }
            Text(text=name,
                modifier=Modifier
                    .width(70.dp)
                    .padding(top=5.dp),
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}



//@Preview
//@Composable
//fun PortraitPreview(){
//    Portrait()
//}