package com.example.k_app_v2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            LoginScreen()
        }
    }

    @Composable
    private fun LoginScreen(modifier: Modifier = Modifier) {
        var nume by remember { mutableStateOf("") }
        var username by remember { mutableStateOf("") }
        var parola by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFFCEE7D3))
                //.background(Color(0XFFB4D9BC))
                .padding(start = 23.dp, end = 23.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Text(
                text = stringResource(R.string.login_text),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    //.background(Color(0XFF9AB9A1))
                    .padding(bottom = 16.dp)
            )

            EditLoginFields(
                label = R.string.nume_text,
                value = nume,
                onValueChanged = { nume = it },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth(),
            )

            EditLoginFields(
                label = R.string.username_text,
                value = username,
                onValueChanged = { username = it },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth()
            )

            EditLoginFields(
                label = R.string.parola_text,
                value = parola,
                onValueChanged = { parola = it },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth()
            )

            EditLoginFields(
                label = R.string.email_text,
                value = email,
                onValueChanged = { email = it },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )

            Row() {
                Button(
                    onClick = { changeScreenMainMenu() },
                    colors = ButtonColors(
                        containerColor = Color(0xFF85A58D),
                        contentColor = Color.White,
                        disabledContentColor = Color.LightGray,
                        disabledContainerColor = Color.LightGray
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 8.dp, end = 8.dp)
                ) {
                    Text(text = stringResource(R.string.creeaza_cont_text))
                }

                Button(
                    onClick = { changeScreenSignIn() },
                    colors = ButtonColors(
                        containerColor = Color(0xFF85A58D),//9AB9A1),
                        contentColor = Color.White,
                        disabledContentColor = Color.LightGray,
                        disabledContainerColor = Color.LightGray
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 8.dp, start = 8.dp)
                ) {
                    Text(text = stringResource(R.string.cont_existent_text))
                }
            }
        }

    }

    private fun changeScreenMainMenu() {
        val intent = Intent(this, MeniulPrincipal::class.java)
        startActivity(intent)

        //finish()
    }

    private fun changeScreenSignIn() {
        val intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)

        //finish()
    }

    @Composable
    fun EditLoginFields(
        @StringRes label: Int,
        value: String,
        onValueChanged: (String) -> Unit,
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = value,
            singleLine = true,
            modifier = modifier,
            onValueChange = onValueChanged,
            label = { Text(stringResource(label)) }

        )

    }
}