package com.example.acontactsapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.acontactsapp.model.UserDatabase
import com.example.acontactsapp.model.db
import com.example.acontactsapp.nav.AddContact
import com.example.acontactsapp.ui.details.ProfileDialog
import com.example.acontactsapp.ui.home.components.Entry
import com.example.acontactsapp.ui.home.components.MySearchBar
import com.example.acontactsapp.ui.home.components.Portrait
import com.example.acontactsapp.ui.home.components.RecentRow

@Composable
fun HomePage(controller:NavController){
    val contactDB = UserDatabase.getDatabase(LocalContext.current)
    val homeViewModel = HomeViewModel(contactDB)
    val contactUserList = homeViewModel.userList.collectAsState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color= Color.White)
            .padding(20.dp)
    ){

        LazyColumn {
            item {
                MySearchBar()
                HorizontalDivider(thickness = 2.dp, color = Color.Black)
                Spacer(modifier=Modifier.size(20.dp))
            }
//            item{
//                Text("En son kullanılanlar",
//                    modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
//
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                RecentRow()
//                Spacer(modifier=Modifier.size(20.dp))
//            }
            item{
                Text("Tüm Kişiler",
                    modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                    )

                Spacer(modifier=Modifier.size(5.dp))

            }
            items(contactUserList.value.size){
                val openAlertDialog = remember { mutableStateOf(false) }
                Entry(
                    contactUserList.value[it].name,
                    contactUserList.value[it].surname,
                    contactUserList.value[it].email,
                    contactUserList.value[it].phone
                ){
                    openAlertDialog.value = true
                }
                if(openAlertDialog.value){
                    ProfileDialog(
                        onDismiss = {openAlertDialog.value = false},
                        name = contactUserList.value[it].name,
                        surname = contactUserList.value[it].surname,
                        phone = contactUserList.value[it].phone,
                        deleteUser = {homeViewModel.deleteUser(contactUserList.value[it].phone)}
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
        FloatingActionButton(
            onClick = {controller.navigate(AddContact)},
            modifier = Modifier.align(Alignment.BottomEnd),
            containerColor = Color.Black,
            contentColor = Color.White,
        ) {
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = "",
                modifier = Modifier.size(30.dp)
            )
        }


    }
}

//@Preview
//@Composable
//fun HomePagePreview(){
//    HomePage()
//}