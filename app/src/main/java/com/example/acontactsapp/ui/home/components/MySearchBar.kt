package com.example.acontactsapp.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySearchBar(){
    val searchText = remember {mutableStateOf("")}
    val isVisible = remember { mutableStateOf(true) }
    val perc = remember { mutableStateOf(0.2f) }
    val focusManager = LocalFocusManager.current


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color= Color.White)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {

        SearchBar(
            modifier = Modifier.weight(perc.value),
            inputField = {
                TextField(
                    modifier = Modifier.onFocusChanged {
                        isVisible.value = if (it.isFocused) false else true
                    },
                    value=searchText.value,
                    onValueChange = {searchText.value = it},
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            modifier = Modifier.size(50.dp)

                        )
                    },
                    keyboardActions = KeyboardActions(onDone = {focusManager.clearFocus()}),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    )
                )
            },
            expanded = false,
            onExpandedChange = {},

        ){

        }
        if(isVisible.value){
            Text(
                modifier = Modifier.weight(1-perc.value),
                text = " Kişilerim ",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }


    }
}

@Preview
@Composable
fun MySearchBarPreview(){
    MySearchBar()
}