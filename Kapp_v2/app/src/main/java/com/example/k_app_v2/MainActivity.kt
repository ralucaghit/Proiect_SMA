package com.example.k_app_v2

import android.os.Bundle
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.k_app_v2.ui.theme.Kapp_v2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kapp_v2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(), //pune pe tot ecranul
                    color = MaterialTheme.colorScheme.background
                ) {
                    FirstScreen()
                }
            }
        }
    }

    @Composable
    fun FirstScreen(modifier: Modifier = Modifier) {

        Box(modifier) {
            Image(
                painter = painterResource(id = R.drawable.k_app_design_v4),
                contentDescription = null,
                contentScale = ContentScale.Crop, //face imaginea pe intreg ecranul
                //alpha = 0.9f
            )

            FirstScreenText()

        }
    }

    @Composable
    fun FirstScreenText(modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = stringResource(R.string.start_text),
                fontSize = 47.sp,
                lineHeight = 51.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 100.dp)
            )

            Button(
                onClick = { changeScreen() },
                colors = ButtonColors(
                    containerColor = Color(0xFF9AB9A1),
                    contentColor = Color.White,
                    disabledContentColor = Color.LightGray,
                    disabledContainerColor = Color.LightGray
                ),
                modifier = Modifier.padding(top = 10.dp)
            ){
                Text(text = "Start")
            }
        }
    }

    private fun changeScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

        //finish()
    }
}





/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kapp_v2Theme {
        Greeting("Android")
    }
}*/