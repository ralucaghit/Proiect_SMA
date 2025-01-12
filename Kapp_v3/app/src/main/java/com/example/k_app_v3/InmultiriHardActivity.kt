package com.example.k_app_v3

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InmultiriHardActivity : AppCompatActivity() {
    // Variabile pentru numerele operatiei și raspunsul corect
    private var correctAnswer: Int = 0

    // Variabila pentru punctaj
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inmultiri_hard)

        // Legaturi cu elementele din layout
        val tvOperation: TextView = findViewById(R.id.add0Text)
        val etAnswer: EditText = findViewById(R.id.ans0Add)
        val btnCheck: Button = findViewById(R.id.verif0BtnAdd)
        val tvResult: TextView = findViewById(R.id.rez0Add)
        val tvScore: TextView = findViewById(R.id.scor0Add)

        // Generam prima operatie
        generateNewOperation(tvOperation, etAnswer, tvResult)

        // Verificarea raspunsului la apasarea butonului
        btnCheck.setOnClickListener {
            val userAnswer = etAnswer.text.toString()

            if (userAnswer.isEmpty()) {
                Toast.makeText(this, "Te rog să introduci un răspuns!", Toast.LENGTH_SHORT).show()
            } else {
                val userAnswerInt = userAnswer.toInt()
                if (userAnswerInt == correctAnswer) {
                    tvResult.text = "Corect! 🎉"
                    tvResult.setTextColor(getColor(android.R.color.holo_green_dark))

                    score++
                    tvScore.text = "Scor: $score"
                } else {
                    tvResult.text = "Greșit! Răspunsul corect este $correctAnswer."
                    tvResult.setTextColor(getColor(android.R.color.holo_red_light))
                }

                // Asteapta 3 secunde si apoi genereaza o noua operatie
                Handler(Looper.getMainLooper()).postDelayed({
                    generateNewOperation(tvOperation, etAnswer, tvResult)
                }, 3000) // 3000 milisecunde = 3 secunde
            }
        }
    }

    // Functie pentru generarea unei noi operatii
    private fun generateNewOperation(
        tvOperation: TextView,
        etAnswer: EditText,
        tvResult: TextView
    ) {
        // Generam două numere aleatorii
        val num1 = (0..1000).random()
        val num2 = (0..1000).random()
        correctAnswer = num1 * num2

        // Actualizam TextView-ul cu noua operatie
        tvOperation.text = "$num1 x $num2 ="

        // Resetam campurile pentru noua runda
        etAnswer.text.clear()
        tvResult.text = ""
    }
}