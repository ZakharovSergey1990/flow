package com.example.flowusecase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.flowusecase.ui.theme.FlowUseCaseTheme
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : ComponentActivity() {

    @InternalCoroutinesApi
    var vm = MainViewModel()

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FlowUseCaseTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(floatingActionButton = {
                    FloatingActionButton(onClick = { vm.addUser() }) {
                        Text("+")
                    }
                }) {
                    Surface(color = MaterialTheme.colors.background) {
                        val users by vm.users.collectAsState()
                        Column() {
                            users.forEach { name ->
                                Text(text = name)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FlowUseCaseTheme {
        Greeting("Android")
    }
}