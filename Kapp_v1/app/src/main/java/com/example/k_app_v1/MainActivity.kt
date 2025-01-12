package com.example.k_app_v1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
//import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.*
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.k_app_v1.ui.theme.Kapp_v1Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kapp_v1Theme {
                MainScreen()
            }
        }
    }
}


@Composable
fun MainScreen() {
    // Starea pentru a controla ce "ecran" să fie vizibil
    var isMenuVisible by remember { mutableStateOf(false) }

    // Dacă isMenuVisible este true, afișăm meniul principal, altfel afișăm ecranul principal
    if (isMenuVisible) {
        // Afișează meniul principal
        MenuScreen()
    } else {
        // Afișează ecranul principal
        HomeScreen(onStartButtonClick = { isMenuVisible = true }, image = painterResource(R.drawable.k_app_design))
    }
}

@Composable
fun HomeScreen(onStartButtonClick: () -> Unit, image: Painter, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop, //face imaginea pe intreg ecranul
            modifier = Modifier
                //.padding(top = 16.dp)
                .height(900.dp)
        )

        Column(
            verticalArrangement = Arrangement.Center, //pune elementele din Column pe mijlocul ecranului
            modifier = Modifier.fillMaxSize()
                //.padding(top = 40.dp)
        ) {
            Text(
                text = "Hai să învățăm împreună cu K-app!",
                fontSize = 50.sp,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center //Centreaza textul pe mijloc
                //modifier = Modifier.padding(bottom = 5.dp) // Adaugă puțin spațiu sub text
            )

            Button(
                onClick = { onStartButtonClick() },
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(10.dp)
            ) {
                Text(
                    text = "Start"
                )
            }
        }
    }
}

@Composable
fun MenuScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column(
            //modifier = Modifier.align(Alignment.Center)
        ) {
            // Partea de sus cu textul "Meniu principal"
            Text(
                text = "Meniul principal",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth().padding(top = 30.dp), // Adăugăm puțin spațiu deasupra textului
                //horizontalAlignment = Alignment.CenterHorizontally
                )

            Spacer(modifier = Modifier.height(250.dp)) // Spațiu între text și butoane

            // Butoanele din mijloc: Matematica și Limba Română
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth().padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Butonul "Matematica"
                Button(
                    onClick = { /* Acțiune pentru Matematica */ },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .size(150.dp) // Dimensiune patrată
                ) {
                    Text(text = "Matematică")
                }

                // Butonul "Limba Romana"
                Button(
                    onClick = { /* Acțiune pentru Limba Romana */ },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .size(150.dp) // Dimensiune patrată
                ) {
                    Text(text = "  Limba Română",
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(240.dp)) // Spațiu între butoane mari și butoane mici

            // Butoanele din jos: Profil și Progresul meu
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 100.dp, bottom = 25.dp), // Spațiu start si de jos
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Butonul "Profil"
                Button(
                    onClick = { /* Acțiune pentru Profil */ },
                    shape = RoundedCornerShape(37.dp),
                    modifier = Modifier
                        .size(120.dp) // Dimensiune patrată mai mică
                ) {
                    Text(text = "Profil")
                }

                // Butonul "Progresul meu"
                Button(
                    onClick = { /* Acțiune pentru Progresul meu */ },
                    shape = RoundedCornerShape(37.dp),
                    modifier = Modifier
                        .size(120.dp) // Dimensiune patrată mai mică
                ) {
                    Text(text = "Progresul\n    meu")
                }
            }
        }
    }
}



/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kapp_v1Theme {
        Greeting("Android")
    }
}*/