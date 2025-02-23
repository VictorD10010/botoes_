package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text("Small Top App Bar")
                            }
                        )
                    },
                    content = { paddingValues ->
                        // Define the content of your Scaffold
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues)
                                .padding(16.dp) // Adding some padding around the content
                        ) {

                            Spacer(modifier = Modifier.height(16.dp)) // Add space between text and button
                            FilledButtonExample(onClick = { /* Handle button click */ })
                            OutlineButtonExample(onClick = { })
                            TonalButtonExample(onClick = { /*TODO*/ })
                                
                            }

                    }
                )
            }
        }
    }
}



@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth() // Ensure the button is visible by filling the width
    ) {
        Text("Filled")
    }
}
@Composable
fun OutlineButtonExample(onClick: ()-> Unit){
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Outlined")
    }
}
@Composable
fun TonalButtonExample(onClick: ()-> Unit){
    FilledTonalButton(
        onClick = onClick, 
        modifier= Modifier.fillMaxWidth()
    ) {
        Text("Tonal")    
    }
}
