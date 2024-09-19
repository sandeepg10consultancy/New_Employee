package com.example.roomdatabaseemployee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomdatabaseemployee.model.Data
import com.example.roomdatabaseemployee.repository.UserRepository
import com.example.roomdatabaseemployee.screens.DetailsScreen
import com.example.roomdatabaseemployee.screens.MainScreen
import com.example.roomdatabaseemployee.screens.NewUserScreen
import com.example.roomdatabaseemployee.screens.UpdateScreen
import com.example.roomdatabaseemployee.ui.theme.RoomDatabaseEmployeeTheme
import com.example.roomdatabaseemployee.utills.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val userViewModel = MainViewModel(UserRepository(RetrofitInstance))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDatabaseEmployeeTheme {
                val navController = rememberNavController()
                val scope = rememberCoroutineScope()
                var users by remember {
                    mutableStateOf(listOf<Data>())
                }
                LaunchedEffect(key1 = true) {
                    scope.launch(Dispatchers.IO){
                        users = MainViewModel(UserRepository(RetrofitInstance)).getUsers()
                    }

                }
                NavHost(navController = navController, startDestination = "MainScreen") {
                    composable(route = "MainScreen") {
                        MainScreen(viewModel = userViewModel, usersList = users, navController = navController)
                    }
                    composable(
                        route = "DetailsScreen?id={id}&fName={fName}&lName={lName}&email={email}&avatar={avatar}", arguments = listOf(
                            navArgument("id") { type = NavType.IntType },
                            navArgument("fName") { type = NavType.StringType },
                            navArgument("lName") { type = NavType.StringType },
                            navArgument("email") { type = NavType.StringType },
                            navArgument("avatar") { type = NavType.StringType }
                    )){
                        it.arguments?.getInt("id")?.let { it1 ->
                            DetailsScreen(
                                id = it1,
                                fName = it.arguments?.getString("fName"),
                                lName = it.arguments?.getString("lName"),
                                email = it.arguments?.getString("email"),
                                avatar = it.arguments?.getString("avatar"),
                                viewModel = userViewModel,
                                navController = navController
                            )
                        }
                    }
                    composable(route = "UpdateScreen?id={id}&fName={fName}&lName={lName}&email={email}", arguments = listOf(
                        navArgument("id") { type = NavType.IntType },
                        navArgument("fName") { type = NavType.StringType },
                        navArgument("lName") { type = NavType.StringType },
                        navArgument("email") { type = NavType.StringType }
                    )){
                        UpdateScreen(navController = navController,viewModel = userViewModel,
                            uid = it.arguments?.getInt("id")!!,
                            ufName = it.arguments?.getString("fName")!!,
                            ulName = it.arguments?.getString("lName")!!,
                            uemail = it.arguments?.getString("email")!!)
                    }
                    composable(route = "NewUserScreen"){
                        NewUserScreen(viewModel = userViewModel)
                    }
                }

            }
        }

    }
}
/*
@Composable
fun Greeting(modifier: Modifier = Modifier,countViewModel: MainViewModel = viewModel()){
    val count = countViewModel.count.observeAsState(0)
    Column {
        Text(
            text = "${count.value}",
            modifier = modifier
        )
        Spacer(modifier = Modifier.padding(top = 50.dp))
        Button(onClick = {
            countViewModel.counting()
        }) {
            Text(text = "count button ${count.value}")

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoomDatabaseEmployeeTheme {
        Greeting()
    }
}

 */