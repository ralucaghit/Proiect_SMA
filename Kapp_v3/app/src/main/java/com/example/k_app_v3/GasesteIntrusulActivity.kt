package com.example.k_app_v3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GasesteIntrusulActivity : AppCompatActivity() {

    // Listă cu întrebări și răspunsuri
    private val questions = listOf(
        Triple("Balon", "Minge", "Pix"), // Pix este intrus
        Triple("Mașină", "Autobuz", "Scaun"), // Scaun este intrus
        Triple("Frunză", "Copac", "Telefon"), // Telefon este intrus
        Triple("Pisică", "Câine", "Carte"), // Cartea este intrus
        Triple("Tricou", "Pantaloni", "Laptop"), // Laptop este intrus
        Triple("Frunză", "Copac", "Creion"),
        Triple("Masă", "Scaun", "Lalea"),
        Triple("Cămașă", "Pantaloni", "Vioară"),
        Triple("Casă", "Apartament", "Mașină"),
        Triple("Tren", "Avion", "Revistă"),
        Triple("Revistă", "Ziar", "Pisică"),
        Triple("Banane", "Portocale", "Jucării"),
        Triple("Măr", "Pară", "Creion"), // Creion este intrus
        Triple("Soare", "Lună", "Scaun"), // Scaun este intrus
        Triple("Trandafir", "Lalea", "Laptop"), // Laptop este intrus
        Triple("Mașină", "Autobuz", "Câine"), // Câine este intrus
        Triple("Frigider", "Cuptor", "Fotoliu"), // Fotoliu este intrus
        Triple("Ocean", "Lac", "Calculator"), // Calculator este intrus
        Triple("Pepene", "Struguri", "Pix"), // Pix este intrus
        Triple("Ceas", "Termometru", "Pisică"), // Pisică este intrus
        Triple("Gogoașă", "Brioșă", "Telefon"), // Telefon este intrus
        Triple("Bec", "Lumină", "Câine"), // Câine este intrus
        Triple("Tort", "Prăjitură", "Mătură"), // Frigider este intrus
        Triple("Bicicletă", "Skateboard", "Lalea"), // Casă este intrus
        Triple("Șosete", "Pantofi", "Laptop"), // Laptop este intrus
        Triple("Telefon", "Tabletă", "Autobuz"), // Autobuz este intrus
        Triple("Pădure", "Copac", "Tastatură"), // Tastatură este intrus
        Triple("Mașină de spălat", "Aragaz", "Fluture"), // Fluture este intrus
        Triple("Cafea", "Ceai", "Tricou"), // Tricou este intrus
        Triple("Apă", "Suc", "Jachetă"), // Jachetă este intrus
        Triple("Nisip", "Val", "Laptop"), // Laptop este intrus
        Triple("Umbrelă de plajă", "Șezlong", "Tastatură"), // Tastatură este intrus
        Triple("Leagăn", "Balansoar", "Telefon"), // Telefon este intrus
        Triple("Zăpadă", "Fulgi", "Frigider"), // Frigider este intrus
        Triple("Plajă", "Mare", "Calculator"), // Calculator este intrus
        Triple("Cămașă", "Rochie", "Scaun"), // Scaun este intrus
        Triple("Statuie", "Monument", "Papagal"), // Papagal este intrus
        Triple("Ciocolată", "Înghețată", "Candelabru"), // Candelabru este intrus
        Triple("Portofel", "Bani", "Fluture"), // Fluture este intrus
        Triple("Revistă", "Ziar", "Avion"), // Avion este intrus
        Triple("Râu", "Izvor", "Mixer"), // Mixer este intrus
        Triple("Televizor", "Radio", "Pix"), // Pix este intrus
        Triple("Pantaloni", "Tricou", "Carte"), // Cartea este intrus
        Triple("Pisică", "Papagal", "Frigider"), // Frigider este intrus
        Triple("Brad", "Pin", "Laptop"), // Laptop este intrus
        Triple("Casă", "Apartament", "Papagal"), // Papagal este intrus
        Triple("Școală", "Elev", "Șosea"), //
        Triple("Tren", "Autobuz", "Pește"), // Pește este intrus
        Triple("Morcovi", "Ceapă", "Scaun"), // Scaun este intrus
        Triple("Teren", "Stadion", "Laptop"), // Laptop este intrus
        Triple("Cărucior", "Leagăn", "Fântână"), // Cărucior este intrus
        Triple("Livadă", "Pomi", "Monitor"), // Monitor este intrus

    )

    private var correctAnswer: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gaseste_intrusul)

        // Legături cu elementele din layout
        val btnOption1: Button = findViewById(R.id.btnOption1)
        val btnOption2: Button = findViewById(R.id.btnOption2)
        val btnOption3: Button = findViewById(R.id.btnOption3)
        val tvResult: TextView = findViewById(R.id.tvResult)

        // Funcție pentru generarea unei întrebări
        fun generateQuestion() {
            val question = questions.random()
            val options = listOf(question.first, question.second, question.third).shuffled()

            // Afișăm opțiunile pe butoane
            btnOption1.text = options[0]
            btnOption2.text = options[1]
            btnOption3.text = options[2]

            // Setăm răspunsul corect
            correctAnswer = question.third
        }

        // Generăm prima întrebare
        generateQuestion()

        // Funcție pentru verificarea răspunsului
        fun checkAnswer(selectedOption: String) {
            if (selectedOption == correctAnswer) {
                tvResult.text = "Corect! 🎉"
                tvResult.setTextColor(getColor(android.R.color.holo_green_dark))
            } else {
                tvResult.text = "Greșit! Cuvântul intrus este $correctAnswer."
                tvResult.setTextColor(getColor(android.R.color.holo_red_dark))
            }

            // Generăm o nouă întrebare după 2 secunde
            tvResult.postDelayed({
                tvResult.text = ""
                generateQuestion()
            }, 2500)
        }

        // Setăm evenimentele pentru fiecare buton
        btnOption1.setOnClickListener { checkAnswer(btnOption1.text.toString()) }
        btnOption2.setOnClickListener { checkAnswer(btnOption2.text.toString()) }
        btnOption3.setOnClickListener { checkAnswer(btnOption3.text.toString()) }
    }
}