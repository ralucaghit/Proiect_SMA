package com.example.k_app_v3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val mathButton: Button = findViewById(R.id.math_btn)
        val romButton: Button = findViewById(R.id.romana_btn)

        mathButton.setOnClickListener{
            val intent = Intent(this, MateActivity::class.java)
            startActivity(intent)
        }

        romButton.setOnClickListener{
            val intent = Intent(this, RomanaActivity::class.java)
            startActivity(intent)
        }
    }
}