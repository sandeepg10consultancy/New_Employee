package com.example.roomdatabaseemployee.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.roomdatabaseemployee.MainViewModel

@Composable
fun UpdateScreen(navController: NavHostController,
                 viewModel: MainViewModel,
                 uid:Int,
                 ufName:String,
                 ulName:String,
                 uemail:String) {
    val myContext = LocalContext.current
    var id by remember {
        mutableStateOf(uid)
    }
    var fName by remember {
        mutableStateOf(ufName)
    }
    var lName by remember {
        mutableStateOf(ulName)
    }
    var email by remember {
        mutableStateOf(uemail)
    }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "Updating Employee",
            color = Color.Black,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(value = id.toString(), onValueChange = {id = it.toInt()
        }, label = {
            Text(text = "ID Field")
        }, colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent,
        ))
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(value = fName, onValueChange = {fName = it}, label = {
            Text(text = "ID Field")
        },colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent) )
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(value = lName, onValueChange = {lName = it}, label = {
            Text(text = "ID Field")
        },colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent) )
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(value = email, onValueChange = {email = it}, label = {
            Text(text = "ID Field")
        },colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent) )
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = {
            viewModel.updateUser(myContext,id)
        }) {
            Text(text = "Done")
        }

    }

}
