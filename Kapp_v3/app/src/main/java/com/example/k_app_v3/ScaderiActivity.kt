package com.example.k_app_v3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScaderiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_scaderi)

        val scaderi0Button: Button = findViewById(R.id.scaderi0_btn)
        val scaderi1Button: Button = findViewById(R.id.scaderi1_btn)
        val scaderi2Button: Button = findViewById(R.id.scaderi2_btn)
        val scaderi3Button: Button = findViewById(R.id.scaderi3_btn)
        val scaderi4Button: Button = findViewById(R.id.scaderi4_btn)

        scaderi0Button.setOnClickListener{
            val intent = Intent(this, Scaderi0Activity::class.java)
            startActivity(intent)
        }

        scaderi1Button.setOnClickListener{
            val intent = Intent(this, Scaderi1Activity::class.java)
            startActivity(intent)
        }

        scaderi2Button.setOnClickListener{
            val intent = Intent(this, Scaderi2Activity::class.java)
            startActivity(intent)
        }

        scaderi3Button.setOnClickListener{
            val intent = Intent(this, Scaderi3Activity::class.java)
            startActivity(intent)
        }

        scaderi4Button.setOnClickListener{
            val intent = Intent(this, Scaderi4Activity::class.java)
            startActivity(intent)
        }

    }
}