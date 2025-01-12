package com.example.k_app_v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MeniulPrincipal : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_meniul_principal)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }*/
        setContent{
            MainMenuScreen()
        }
    }

    @Composable
    private fun MainMenuScreen(modifier: Modifier = Modifier){
        Surface(
            //modifier = Modifier.fillMaxSize(), //pune pe tot ecranul
            //color = Color(0XFFBDE4C6)
                //.fillMaxSize()
                //.background(Color(0XFFBDE4C6))
        ) {
            Text(
                text = stringResource(R.string.mainMenu_text),
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier
                    .background(Color(0XFF9AB9A1))
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 15.dp, bottom = 15.dp)
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF85A58D)),
                    modifier = Modifier
                        .height(98.dp) // Setează înălțimea butonului
                        .fillMaxWidth() // Face butonul să ocupe toată lățimea
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp), // Adaugă un padding pe orizontală
                    shape = RoundedCornerShape(26.dp)
                ) {
                    Text(
                        text = stringResource(R.string.mate_text),
                        fontSize = 37.sp
                    )
                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(100.dp) // Setează înălțimea butonului
                        .fillMaxWidth() // Face butonul să ocupe toată lățimea
                        .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 8.dp), // Adaugă un padding pe orizontală
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF85A58D)),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text(
                        text = stringResource(R.string.romana_text),
                        fontSize = 35.sp
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.Bottom,
                //horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Button(
                    onClick = {},
                    colors = ButtonColors(
                        containerColor = Color(0xFF85A58D),
                        contentColor = Color.White,
                        disabledContentColor = Color.LightGray,
                        disabledContainerColor = Color.LightGray
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 5.dp)
                ) {
                    Text(
                        text = stringResource(R.string.progres_text)
                    )
                }

                Button(
                    onClick = {},
                    colors = ButtonColors(
                        containerColor = Color(0xFF85A58D),
                        contentColor = Color.White,
                        disabledContentColor = Color.LightGray,
                        disabledContainerColor = Color.LightGray
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 5.dp)
                ) {
                    Text(
                        text = stringResource(R.string.profil_text)
                    )
                }
            }
        }
    }
}