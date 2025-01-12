package com.example.k_app_v3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GhicesteContextulActivity : AppCompatActivity() {

    // Listă cu întrebări și categorii
    private val questions = listOf(
        Pair(listOf("Baloane", "Tort", "Cadouri"), "Petrecere"),
        Pair(listOf("Caiet", "Pix", "Manual"), "Școală"),
        Pair(listOf("Minge", "Rachetă", "Plasă"), "Sport"),
        Pair(listOf("Pepene", "Căpșuni", "Banane"), "Fructe"),
        Pair(listOf("Pat", "Perna", "Plapumă"), "Dormitor"),
        Pair(listOf("Tren", "Autobuz", "Avion"), "Transport"),
        Pair(listOf("Pisică", "Câine", "Papagal"), "Animale"),
        Pair(listOf("Plajă", "Mare", "Valuri"), "Vacanță"),
        Pair(listOf("Trandafir", "Lalea", "Crin"), "Flori"),
        Pair(listOf("Frigider", "Aragaz", "Cuptor"), "Bucătărie"),
        Pair(listOf("Salată", "Ciorbă", "Friptură"), "Mâncare"),
        Pair(listOf("Bec", "Lanternă", "Lumânare"), "Lumină"),
        Pair(listOf("Tricou", "Pantaloni", "Șosete"), "Îmbrăcăminte"),
        Pair(listOf("Roșii", "Castraveți", "Ceapă"), "Legume"),
        Pair(listOf("Bloc", "Casă", "Apartament"), "Locuință"),
        Pair(listOf("Pădure", "Copac", "Frunză"), "Natură"),
        Pair(listOf("Stea", "Soare", "Lună"), "Cer"),
        Pair(listOf("Ciocolată", "Bomboane", "Prăjitură"), "Desert"),
        Pair(listOf("Role", "Bicicletă", "Skateboard"), "Jucării"),
        Pair(listOf("Fotbal", "Tenis", "Baschet"), "Sport"),
        Pair(listOf("Cartofi", "Morcovi", "Ceapă"), "Legume"),
        Pair(listOf("Piersici", "Caise", "Prune"), "Fructe"),
        Pair(listOf("Șampon", "Gel de duș", "Săpun"), "Igienă"),
        Pair(listOf("Telefon", "Tabletă", "Imprimantă"), "Tehnologie"),
        Pair(listOf("Jachetă", "Geacă", "Fular"), "Îmbrăcăminte"),
        Pair(listOf("Nisip", "Umbrelă", "Șezlong"), "Vacanță"),
        Pair(listOf("Tobogan", "Balansoar", "Leagăn"), "Parc"),
        Pair(listOf("Creion", "Radieră", "Ascuțitoare"), "Școală"),
        Pair(listOf("Gazon", "Trandafir", "Gard"), "Grădină"),
        Pair(listOf("Zăpadă", "Fulgi", "Viscol"), "Iarnă"),
        Pair(listOf("Apă", "Suc", "Cafea"), "Băuturi"),
        Pair(listOf("Ceai", "Lapte", "Apă minerală"), "Băuturi"),
        Pair(listOf("Scaun", "Masă", "Canapea"), "Mobilier"),
        Pair(listOf("Bec", "Candelabru", "Lumânare"), "Lumină"),
        Pair(listOf("Colier", "Inel", "Brățară"), "Bijuterii"),
        Pair(listOf("Fân", "Grajd", "Lan de grâu"), "Fermă"),
        Pair(listOf("Cascadă", "Lac", "Izvor"), "Apă"),
        Pair(listOf("Revistă", "Carte", "Ziar"), "Lectură"),
        Pair(listOf("Ecran", "Cameră video", "Proiector"), "Cinema"),
        Pair(listOf("Papuc", "Sandale", "Pantofi"), "Încălțăminte"),
        Pair(listOf("Brichetă", "Chibrituri", "Foc"), "Aprindere"),
        Pair(listOf("Semințe", "Nuci", "Migdale"), "Gustări"),
        Pair(listOf("Eșarfă", "Pălărie", "Șapcă"), "Accesorii"),
        Pair(listOf("Lanternă", "Far", "Lampă"), "Iluminare"),
        Pair(listOf("Brad", "Pin", "Molid"), "Copaci"),
        Pair(listOf("Vișine", "Cireșe", "Struguri"), "Fructe"),
        Pair(listOf("Pepene", "Mere", "Pere"), "Fructe"),
        Pair(listOf("Aloe", "Musetel", "Busuioc"), "Plante"),
        Pair(listOf("Mașină", "Motocicletă", "Tir"), "Transport"),
        Pair(listOf("Stejar", "Salcâm", "Tei"), "Copaci"),
        Pair(listOf("Fereastră", "Ușă", "Perete"), "Casă"),
        Pair(listOf("Rățușcă", "Lebădă", "Pinguin"), "Păsări"),
        Pair(listOf("Scoică", "Melc", "Coral"), "Mare"),
        Pair(listOf("Calculator", "Tabletă", "Telefon"), "Tehnologie"),
        Pair(listOf("Cană", "Ceainic", "Pahar"), "Veselă"),
        Pair(listOf("Ciorbă", "Tocăniță", "Supă"), "Mâncare"),
        Pair(listOf("Cal", "Pisică", "Găină"), "Animale")
    )

    private var correctCategory: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ghiceste_contextul)

        val tvWords: TextView = findViewById(R.id.tvWords)
        val btnCategory1: Button = findViewById(R.id.btnCategory1)
        val btnCategory2: Button = findViewById(R.id.btnCategory2)
        val tvResult: TextView = findViewById(R.id.tvResult)

        fun generateQuestion() {
            // Alegem o întrebare și amestecăm categoriile pentru afișare
            val question = questions.random()
            val shuffledCategories = listOf(question.second, questions.random().second).shuffled()

            // Setăm textul în interfață
            tvWords.text = question.first.joinToString(", ")
            btnCategory1.text = shuffledCategories[0]
            btnCategory2.text = shuffledCategories[1]
            correctCategory = question.second
        }

        fun checkAnswer(selectedCategory: String) {
            if (selectedCategory == correctCategory) {
                tvResult.text = "Corect! Categoria este $correctCategory. 🎉"
                tvResult.setTextColor(getColor(android.R.color.holo_green_dark))
            } else {
                tvResult.text = "Greșit! Categoria corectă era $correctCategory."
                tvResult.setTextColor(getColor(android.R.color.holo_red_light))
            }

            // Generăm o nouă întrebare după 2 secunde
            tvResult.postDelayed({
                tvResult.text = ""
                generateQuestion()
            }, 2000)
        }

        // Setăm acțiunile pentru butoane
        btnCategory1.setOnClickListener { checkAnswer(btnCategory1.text.toString()) }
        btnCategory2.setOnClickListener { checkAnswer(btnCategory2.text.toString()) }

        // Generăm prima întrebare
        generateQuestion()
    }
}