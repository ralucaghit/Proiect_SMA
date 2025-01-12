package com.example.k_app_v2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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

class SigninActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            SignInScreen()
        }
    }

    @Composable
    private fun SignInScreen(modifier: Modifier = Modifier) {
        var parola by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFFCEE7D3))
                .padding(start = 23.dp, end = 23.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Text(
                text = stringResource(R.string.connect_text),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    //.background(Color(0XFF9AB9A1))
                    .padding(bottom = 16.dp)
            )

            EditSignInFields(
                label = R.string.email_text,
                value = email,
                onValueChanged = { email = it },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth(),
            )

            EditSignInFields(
                label = R.string.parola_text,
                value = parola,
                onValueChanged = { parola = it },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth(),
            )

            Button(
                onClick = { changeScreenMainMenu() },
                colors = ButtonColors(
                    containerColor = Color(0xFF85A58D),
                    contentColor = Color.White,
                    disabledContentColor = Color.LightGray,
                    disabledContainerColor = Color.LightGray
                ),
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(text = stringResource(R.string.connect_text))
            }
        }
    }

    private fun changeScreenMainMenu() {
        val intent = Intent(this, MeniulPrincipal::class.java)
        startActivity(intent)

        //finish()
    }

    @Composable
    fun EditSignInFields(
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