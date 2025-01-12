package com.example.k_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.k_app.ui.theme.KappTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            KappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Greeting()
                }
            }
        }
    }
}
/*
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = "Hai să învățăm împreună cu K-app!",
        modifier = Modifier.wrapContentSize(Alignment.Center)
    )
}*/
@Composable
fun Greeting() {
    // Folosim un Column pentru a aranja Text și Button pe verticală
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center) // Centrează tot pe ecran
    ) {
        // Textul
        Text(
            text = "Hai să învățăm împreună cu K-app!",
            modifier = Modifier.padding(bottom = 16.dp) // Adaugă puțin spațiu sub text
        )

        // Butonul
        Button(
            onClick = { /* Aici poți adăuga acțiunea butonului */ },
            modifier = Modifier.padding(top = 16.dp) // Adaugă puțin spațiu deasupra butonului
        ) {
            Text(text = "Start")
        }
    }
}
/*
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Gray) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hai să învățăm împreună cu K-app!",
                modifier = Modifier.wrapContentSize(Alignment.Center)
            )

            Button(onClick = {}) {
                Text(
                    text = "Start",
                    //modifier = Modifier.wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}*/

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KappTheme {
        Greeting("Android")
    }
}*/
