package com.example.roomdatabaseemployee.screens

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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roomdatabaseemployee.MainViewModel
import com.example.roomdatabaseemployee.model.Data

@Composable
fun NewUserScreen(viewModel: MainViewModel) {
    var id by remember {
        mutableIntStateOf(0)
    }
    var fName by remember{
        mutableStateOf("")
    }
    var lName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var avatar by remember {
        mutableStateOf("")
    }
    val myContext = LocalContext.current
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "New Employee",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic)
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(value = id.toString(), onValueChange = {id = it.toInt()}, label = {
            Text(text = "Enter ID")
        },colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent) )
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(value = fName, onValueChange = {fName = it}, label = {
            Text(text = "Enter First Name")
        },colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent) )
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(value = lName, onValueChange = {lName = it}, label = {
            Text(text = "Enter Second Name")
        },colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent) )
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(value = email, onValueChange = {email = it}, label = {
            Text(text = "Enter Email")
        },colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent) )
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(value = avatar, onValueChange = {avatar = it}, label = {
            Text(text = "Enter Avatar address")
        },colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent) )
        Spacer(modifier = Modifier.padding(15.dp))
        Button(onClick = {
            viewModel.createEmployee(myContext,Data(avatar = avatar,email = email, first_name = fName,id = id, last_name = lName))
        }) {
            Text(text = "Submit")
        }
    }
}
