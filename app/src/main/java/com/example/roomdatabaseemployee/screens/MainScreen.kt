package com.example.roomdatabaseemployee.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.roomdatabaseemployee.MainViewModel
import com.example.roomdatabaseemployee.model.Data


@Composable
fun MainScreen(viewModel: MainViewModel, usersList: List<Data>, navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
    ){
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Employees List",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
            Button(onClick = {
                navController.navigate(route = "NewUserScreen")
            }) {
                Text(text = "Create")

            }
        }

        LazyColumn {
            items(usersList, key = {it.id}){item ->
                EmployeeItem(
                    itemFname = item.first_name,
                    itemLname = item.last_name,
                    itemEmail = item.email,
                    itemAvatar = item.avatar,
                    itemId = item.id,
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EmployeeItem(
    itemFname: String,
    itemAvatar: String,
    viewModel: MainViewModel,
    itemId: Int,
    navController: NavHostController,
    itemEmail:String,
    itemLname: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                navController.navigate("DetailsScreen?id=$itemId&fName=$itemFname&lName=$itemLname&email=$itemEmail&avatar=$itemAvatar")

            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray
        )
    ){
        Row(
            modifier = Modifier
                .padding(8.dp)
                .wrapContentSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(model = itemAvatar, contentDescription = "profile",
                modifier = Modifier.clip(CircleShape))
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = itemFname,
                modifier = Modifier
                    .fillMaxSize()
                    .basicMarquee(),
                fontSize = 20.sp)
        }

    }

}