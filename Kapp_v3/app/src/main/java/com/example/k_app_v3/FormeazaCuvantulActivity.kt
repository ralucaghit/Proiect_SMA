package com.example.k_app_v3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormeazaCuvantulActivity : AppCompatActivity() {

    // Lista de cuvinte
    private val words = listOf(
        "cuvânt", "pisică", "minge", "plajă", "copac", "școală", "soare", "frunză",
        "mașină", "baloane", "tort", "lumină", "telefon", "creion", "pahar", "mama",
        "tata"
    )

    private var currentWord: String = ""
    private var missingLetter: Char = ' '

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formeaza_cuvantul)

        val tvQuestion: TextView = findViewById(R.id.tvQuestion)
        val etAnswer: EditText = findViewById(R.id.etAnswer)
        val btnCheck: Button = findViewById(R.id.btnCheck)
        val tvResult: TextView = findViewById(R.id.tvResult)

        fun generateQuestion() {
            // Alegem un cuvânt aleatoriu și scoatem o literă
            currentWord = words.random()
            val missingIndex = (currentWord.indices).random()
            missingLetter = currentWord[missingIndex]
            val displayedWord = StringBuilder(currentWord).apply { setCharAt(missingIndex, '_') }

            // Actualizăm întrebarea
            tvQuestion.text = "Completează cuvântul: $displayedWord"
            etAnswer.text.clear()
            tvResult.text = ""
        }

        fun checkAnswer() {
            val userInput = etAnswer.text.toString().trim()

            if (userInput.length == 1 && userInput[0] == missingLetter) {
                tvResult.text = "Corect! Cuvântul este \"$currentWord\". 🎉"
                tvResult.setTextColor(getColor(android.R.color.holo_green_dark))
            } else {
                tvResult.text = "Greșit! Litera corectă era \"$missingLetter\"."
                tvResult.setTextColor(getColor(android.R.color.holo_red_light))
            }

            // Generăm o nouă întrebare după 2 secunde
            tvResult.postDelayed({
                generateQuestion()
            }, 2000)
        }

        // Setăm acțiunea pentru buton
        btnCheck.setOnClickListener { checkAnswer() }

        // Generăm prima întrebare
        generateQuestion()
    }
}