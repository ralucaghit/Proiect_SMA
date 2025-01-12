package com.example.k_app_v3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InmultiriActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inmultiri)

        val easyButton: Button = findViewById(R.id.inmEasy_btn)
        val mediumButton: Button = findViewById(R.id.inmMedium_btn)
        val hardButton: Button = findViewById(R.id.inmHard_btn)

        easyButton.setOnClickListener{
            val intent = Intent(this, InmultiriEasyActivity::class.java)
            startActivity(intent)
        }

        mediumButton.setOnClickListener{
            val intent = Intent(this, InmultiriMediumActivity::class.java)
            startActivity(intent)
        }

        hardButton.setOnClickListener{
            val intent = Intent(this, InmultiriHardActivity::class.java)
            startActivity(intent)
        }
    }
}