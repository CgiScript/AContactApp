package com.example.acontactsapp.ui.home.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.acontactsapp.model.db

@Composable
fun RecentRow(){
    val recents = db
    LazyRow {
        items(5){
                Portrait(db[it].name)
                Spacer(modifier = Modifier.size(15.dp))
        }
    }
}



@Preview
@Composable
fun RecentRowPreview(){
    RecentRow()
}