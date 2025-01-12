package com.example.k_app_v3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mate)

        val adunariButton: Button = findViewById(R.id.adunari_btn)
        val scaderiButton: Button = findViewById(R.id.scaderi_btn)
        val inmultiriButton: Button = findViewById(R.id.inmultiri_btn)

        adunariButton.setOnClickListener{
            val intent = Intent(this, AdunariActivity::class.java)
            startActivity(intent)
        }

        scaderiButton.setOnClickListener{
            val intent = Intent(this, ScaderiActivity::class.java)
            startActivity(intent)
        }

        inmultiriButton.setOnClickListener{
            val intent = Intent(this, InmultiriActivity::class.java)
            startActivity(intent)
        }
    }
}