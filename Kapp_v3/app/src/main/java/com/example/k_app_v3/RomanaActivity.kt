package com.example.k_app_v3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RomanaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_romana)

        val gasesteIntrusButton: Button = findViewById(R.id.gasesteIntrusBtn)
        val ghicesteContextButton: Button = findViewById(R.id.ghicesteContextBtn)
        val formeazaCuvantButton: Button = findViewById(R.id.formeazaCuvantBtn)
        val grupLitereButton: Button = findViewById(R.id.grupLitereBtn)

        gasesteIntrusButton.setOnClickListener{
            val intent = Intent(this, GasesteIntrusulActivity::class.java)
            startActivity(intent)
        }

        ghicesteContextButton.setOnClickListener{
            val intent = Intent(this, GhicesteContextulActivity::class.java)
            startActivity(intent)
        }

        formeazaCuvantButton.setOnClickListener{
            val intent = Intent(this, FormeazaCuvantulActivity::class.java)
            startActivity(intent)
        }

        grupLitereButton.setOnClickListener{
            val intent = Intent(this, GrupuriLitereActivity::class.java)
            startActivity(intent)
        }
    }
}