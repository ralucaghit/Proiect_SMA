package com.example.k_app_v3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AdunariActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_adunari)

        val adunari0Button: Button = findViewById(R.id.adunari0_btn)
        val adunari1Button: Button = findViewById(R.id.adunari1_btn)
        val adunari2Button: Button = findViewById(R.id.adunari2_btn)
        val adunari3Button: Button = findViewById(R.id.adunari3_btn)
        val adunari4Button: Button = findViewById(R.id.adunari4_btn)

        adunari0Button.setOnClickListener{
            val intent = Intent(this, Adunari0Activity::class.java)
            startActivity(intent)
        }
        adunari1Button.setOnClickListener{
            val intent = Intent(this, Adunari1Activity::class.java)
            startActivity(intent)
        }
        adunari2Button.setOnClickListener{
            val intent = Intent(this, Adunari2Activity::class.java)
            startActivity(intent)
        }
        adunari3Button.setOnClickListener{
            val intent = Intent(this, Adunari3Activity::class.java)
            startActivity(intent)
        }
        adunari4Button.setOnClickListener{
            val intent = Intent(this, Adunari4Activity::class.java)
            startActivity(intent)
        }

    }
}