package com.example.k_app_v3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GrupuriLitereActivity : AppCompatActivity() {

    // Lista de cuvinte cu grupuri de litere lipsă
    private val wordGroups = listOf(
        Triple("__afă", "ce", "ci"), // ce (ceafă)
        Triple("__ai", "ce", "ci"), // ce (ceai)
        Triple("__apă", "ce", "ci"), // ce (ceapă)
        Triple("__arceaf", "ce", "ci"), // ce (cearceaf)
        Triple("cear__af", "ce", "ci"), // ce (cearceaf)
        Triple("__ară", "ce", "ci"), // ce (ceară)
        Triple("__artă", "ce", "ci"), // ce (ceartă)
        Triple("__as", "ce", "ci"), // ce (ceas)
        Triple("__așcă", "ce", "ci"), // Răspuns corect: ce (ceașcă)
        Triple("__ață", "ce", "ci"), // ce (ceață)
        Triple("__rb", "ce", "ci"), // ce (cerb)
        Triple("__rc", "ce", "ci"), // ce (cerc)
        Triple("bo__t", "ce", "ci"), // ce (bocet)
        Triple("__ntru", "ce", "ci"), // ce (centru)
        Triple("__rcel", "ce", "ci"), // ce (cercel)
        Triple("con__rt", "ce", "ci"), // ce (concert)
        Triple("cru__", "ce", "ci"), // ce (cruce)
        Triple("dul__", "ce", "ci"), // ce (dulce)
        Triple("fran__z", "ce", "ci"), // ce (francez)
        Triple("în__t", "ce", "ci"), // ce (incet)
        Triple("li__u", "ce", "ci"), // ce (liceu)
        Triple("o__an", "ce", "ci"), // ce (ocean)
        Triple("pro__s", "ce", "ci"), // ce (proces)
        Triple("pur__l", "ce", "ci"), // ce (purcel)
        Triple("re__", "ce", "ci"), // ce (rece)
        Triple("re__nt", "ce", "ci"), // ce (recent)
        Triple("s__nă", "ce", "ci"), // ce (scena)
        Triple("sin__r", "ce", "ci"), // ce (sincer)
        Triple("suc__s", "ce", "ci"), // ce (succes)
        Triple("tre__re", "ce", "ci"), // ce (trecere)
        Triple("vo__", "ce", "ci"), // ce (voce)
        Triple("ze__", "ce", "ci"), // ce (zece)
        Triple("afa__re", "ce", "ci"), // ce (afacere)
        Triple("binefa__re", "ce", "ci"), // ce (binefacere)
        Triple("căldi__l", "ce", "ci"), // ce (căldicel)
        Triple("cânte__l", "ce", "ci"), // ce (cântecel)
        Triple("carapa__", "ce", "ci"), // ce (carapace)
        Triple("__lebru", "ce", "ci"), // ce (celebru)
        Triple("__ntimetru", "ce", "ci"), // ce (centimetru)
        Triple("__nușă", "ce", "ci"), // ce (cenusa)
        Triple("cer__taș", "ce", "ci"), // ce (cercetas)
        Triple("__rneală", "ce", "ci"), // ce (cerneala)
        Triple("__tate", "ce", "ci"), // ce (cetate)
        Triple("cu__ritor", "ce", "ci"), // ce (cuceritor)
        Triple("de__mbrie", "ce", "ci"), // ce (decembrie)
        Triple("dovle__l", "ce", "ci"), // ce (dovlecel)
        Triple("ex__lent", "ce", "ci"), // ce (excelent)
        Triple("gândă__l", "ce", "ci"), // ce (gandacel)
        Triple("ghio__l", "ce", "ci"), // ce (ghiocel)
        Triple("in__ndiu", "ce", "ci"), // ce (incendiu)
        Triple("în__pător", "ce", "ci"), // ce (incepator)
        Triple("lu__afăr", "ce", "ci"), // ce (luceafar)
        Triple("mă__lar", "ce", "ci"), // ce (macelar)
        Triple("ne__sar", "ce", "ci"), // ce (necesar)
        Triple("mu__gai", "ce", "ci"), // ce (mucegai)
        Triple("ră__ală", "ce", "ci"), // ce (raceala)
        Triple("re__pție", "ce", "ci"), // ce (receptie)
        Triple("rino__r", "ce", "ci"), // ce (rinocer)
        Triple("s__netă", "ce", "ci"), // ce (sceneta)
        Triple("șori__l", "ce", "ci"), // ce (soricel)
        Triple("u__nic", "ce", "ci"), // ce (ucenic)
        Triple("sprân__ană", "ce", "ci"), // ce (spranceana)

        Triple("__ob", "ci", "ce"), // ci (ciob)
        Triple("__oc", "ci", "ce"), // ci (cioc)
        Triple("__ment", "ci", "ce"), // ci (ciment)
        Triple("__oară", "ci", "ce"), // ci (cioară)
        Triple("__oban", "ci", "ce"), // ci (cioban)
        Triple("__orap", "ci", "ce"), // ci (ciorap)
        Triple("__orbă", "ci", "ce"), // ci (ciorbă)
        Triple("ul__or", "ci", "ce"), // ci (ulcior)
        Triple("cin__", "ci", "ce"), // ci (cinci)
        Triple("__rc", "ci", "ce"), // ci (circ)
        Triple("mi__", "ci", "ce"), // ci (mici)
        Triple("ari__", "ci", "ce"), // ci (arici)
        Triple("cal__u", "ci", "ce"), // ci (calciu)
        Triple("__fră", "ci", "ce"), // ci (cifra)
        Triple("__nă", "ci", "ce"), // ci (cina)
        Triple("__ocan", "ci", "ce"), // ci (ciocan)
        Triple("__reașă", "ci", "ce"), // ci (cireasa)
        Triple("__udat", "ci", "ce"), // ci (ciudat)
        Triple("__vil", "ci", "ce"), // ci (civil)
        Triple("__zmă", "ci", "ce"), // ci (cizma)
        Triple("Cră__un", "ci", "ce"), // ci (Craciun)
        Triple("lipi__", "ci", "ce"), // ci (lipici)
        Triple("sandvi__", "ci", "ce"), // ci (sandvici)
        Triple("vac__n", "ci", "ce"), // ci (vaccin)
        Triple("zgâr__t", "ci", "ce"), // ci (zgarcit)
        Triple("ac__dent", "ci", "ce"), // ci (accident)
        Triple("artifi__i", "ci", "ce"), // ci (artificii)
        Triple("bi__cletă", "ci", "ce"), // ci (bicicleta)
        Triple("că__ulă", "ci", "ce"), // ci (caciula)
        Triple("cârnă__or", "ci", "ce"), // ci (carnacior)
        Triple("căru__or", "ci", "ce"), // ci (carucior)
        Triple("cau__uc", "ci", "ce"), // ci (cauciuc)
        Triple("__catrice", "ci", "ce"), // ci (cicatrice)
        Triple("__nema", "ci", "ce"), // ci (cinema)
        Triple("__ocănitoare", "ci", "ce"), // ci (ciocanitoare)
        Triple("__ocârlie", "ci", "ce"), // ci (ciocarlie)
        Triple("__ocolată", "ci", "ce"), // ci (ciocolata)
        Triple("__rculație", "ci", "ce"), // ci (circulatie)
        Triple("__ucure", "ci", "ce"), // ci (ciucure)
        Triple("dărni__e", "ci", "ce"), // ci (darnicie)
        Triple("deli__os", "ci", "ce"), // ci (delicios)
        Triple("domi__liu", "ci", "ce"), // ci (domiciliu)
        Triple("efi__ent", "ci", "ce"), // ci (eficient)
        Triple("electri__an", "ci", "ce"), // ci (electrician)
        Triple("en__clopedie", "ci", "ce"), // ci (enciclopedie)
        Triple("farma__e", "ci", "ce"), // ci (farmacie)
        Triple("fe__or", "ci", "ce"), // ci (fecior)
        Triple("in__siv", "ci", "ce"), // ci (incisiv)
        Triple("informati__an", "ci", "ce"), // ci (informatician)
        Triple("licuri__", "ci", "ce"), // ci (licurici)
        Triple("magi__an", "ci", "ce"), // ci (magician)
        Triple("matemati__an", "ci", "ce"), // ci (matematician)
        Triple("mijlo__u", "ci", "ce"), // ci (mijlociu)
        Triple("muzi__an", "ci", "ce"), // ci (muzician)
        Triple("pi__or", "ci", "ce"), // ci (picior)
        Triple("plă__ntă", "ci", "ce"), // ci (placinta)
        Triple("prin__pal", "ci", "ce"), // ci (principal)
        Triple("publi__tate", "ci", "ce"), // ci (publicitate)
        Triple("rădă__nă", "ci", "ce"), // ci (radacina)
        Triple("răută__os", "ci", "ce"), // ci (rautacios)
        Triple("rugă__une", "ci", "ce"), // ci (rugaciune)
        Triple("sacrifi__u", "ci", "ce"), // ci (sacrificiu)
        Triple("sălbăti__e", "ci", "ce"), // ci (salbaticie)
        Triple("sără__e", "ci", "ce"), // ci (saracie)
        Triple("sclipi__", "ci", "ce"), // ci (sclipici)
        Triple("slăbi__une", "ci", "ce"), // ci (slabiciune)
        Triple("so__abil", "ci", "ce"), // ci (sociabil)
        Triple("spe__al", "ci", "ce"), // ci (special)
        Triple("stânga__", "ci", "ce"), // ci (stangaci)
        Triple("strălu__tor", "ci", "ce"), // ci (stralucitor)
        Triple("tehni__an", "ci", "ce"), // ci (tehnician)
        Triple("to__lar", "ci", "ce"), // ci (tocilar)
        Triple("ve__n", "ci", "ce"), // ci (vecin)
        Triple("voini__", "ci", "ce"), // ci (voinici)

        Triple("__am", "ge", "gi"), // ge (geam)
        Triple("__amăn", "ge", "gi"), // ge (geamăn)
        Triple("__antă", "ge", "gi"), // ge (geantă)
        Triple("măr__a", "ge", "gi"), // ge (mărgea)
        Triple("__m", "ge", "gi"), // ge (gem)
        Triple("a__nt", "ge", "gi"), // ge (agent)
        Triple("de__t", "ge", "gi"), // ge (deget)
        Triple("ful__r", "ge", "gi"), // ge (fulger)
        Triple("__acă", "ge", "gi"), // ge (geacă)
        Triple("în__r", "ge", "gi"), // ge (inger)
        Triple("le__", "ge", "gi"), // ge (lege)
        Triple("min__", "ge", "gi"), // ge (minge)
        Triple("nin__", "ge", "gi"), // ge (ninge)
        Triple("re__", "ge", "gi"), // ge (rege)
        Triple("șter__", "ge", "gi"), // ge (sterge)
        Triple("stin__", "ge", "gi"), // ge (stinge)
        Triple("a__ndă", "ge", "gi"), // ge (agenda)
        Triple("con__lator", "ge", "gi"), // ge (congelator)
        Triple("cori__nt", "ge", "gi"), // ge (corigent)
        Triple("exa__rare", "ge", "gi"), // ge (exagerare)
        Triple("__amantan", "ge", "gi"), // ge (geamantan)
        Triple("__latină", "ge", "gi"), // ge (gelatină)
        Triple("__lozie", "ge", "gi"), // ge (gelozie)
        Triple("__neros", "ge", "gi"), // ge (generos)
        Triple("__niu", "ge", "gi"), // ge (geniu)
        Triple("__nunche", "ge", "gi"), // ge (genunche)
        Triple("__ografie", "ge", "gi"), // ge (geografie)
        Triple("înțele__re", "ge", "gi"), // ge (intelegere)
        Triple("inteli__nt", "ge", "gi"), // ge (inteligent)
        Triple("le__ndă", "ge", "gi"), // ge (legenda)
        Triple("oxi__n", "ge", "gi"), // ge (oxigen)
        Triple("să__ată", "ge", "gi"), // ge (sageata)
        Triple("su__stie", "ge", "gi"), // ge (sugestie)
        Triple("tra__die", "ge", "gi"), // ge (tragedie)
        Triple("ur__nță", "ge", "gi"), // ge (urgenta)
        Triple("ve__tarian", "ge", "gi"), // ge (vegetarian)

        Triple("ar__nt", "gi", "ge"), // gi (argint)
        Triple("a__tație", "gi", "ge"), // gi (agitatie)
        Triple("aler__e", "gi", "ge"), // gi (alergie)
        Triple("amă__re", "gi", "ge"), // gi (amagire)
        Triple("biolo__e", "gi", "ge"), // gi (biologie)
        Triple("blu__", "gi", "ge"), // gi (blugi)
        Triple("chirur__e", "gi", "ge"), // gi (chirurgie)
        Triple("cole__u", "gi", "ge"), // gi (colegiu)
        Triple("dezamă__re", "gi", "ge"), // gi (dezamagire)
        Triple("diri__ntă", "gi", "ge"), // gi (diriginta)
        Triple("ener__e", "gi", "ge"), // gi (energie)
        Triple("fra__l", "gi", "ge"), // gi (fragil)
        Triple("fri__der", "gi", "ge"), // gi (frigider)
        Triple("gălă__e", "gi", "ge"), // gi (galagie)
        Triple("__gant", "gi", "ge"), // gi (gigant)
        Triple("__mnastică", "gi", "ge"), // gi (gimnastică)
        Triple("__mnaziu", "gi", "ge"), // gi (gimnaziu)
        Triple("__nere", "gi", "ge"), // gi (ginere)
        Triple("__ngaș", "gi", "ge"), // gi (gingaș)
        Triple("__rafă", "gi", "ge"), // gi (girafa)
        Triple("i__enă", "gi", "ge"), // gi (igiena)
        Triple("ima__ne", "gi", "ge"), // gi (imagine)
        Triple("in__ner", "gi", "ge"), // gi (inginer)
        Triple("lăr__me", "gi", "ge"), // gi (largime)
        Triple("lo__c", "gi", "ge"), // gi (logic)
        Triple("lun__me", "gi", "ge"), // gi (lungime)
        Triple("ma__e", "gi", "ge"), // gi (magie)
        Triple("mar__ne", "gi", "ge"), // gi (margine)
        Triple("pa__nă", "gi", "ge"), // gi (pagina)
        Triple("prelun__tor", "gi", "ge"), // gi (prelungitor)
        Triple("refu__at", "gi", "ge"), // gi (refugiat)
        Triple("re__m", "gi", "ge"), // gi (regim)
        Triple("re__nă", "gi", "ge"), // gi (regina)
        Triple("re__une", "gi", "ge"), // gi (regiune)
        Triple("re__zor", "gi", "ge"), // gi (regizor)
        Triple("reli__e", "gi", "ge"), // gi (religie)
        Triple("ru__nă", "gi", "ge"), // gi (rugină)
        Triple("stomatolo__e", "gi", "ge"), // gi (stomatologie)
        Triple("strate__e", "gi", "ge"), // gi (strategie)
        Triple("tehnolo__e", "gi", "ge"), // gi (tehnologie)

        Triple("bas__t", "che", "chi"), // che (baschet)
        Triple("bri__tă", "che", "chi"), // che (brichetă)
        Triple("bu__t", "che", "chi"), // che (buchet)
        Triple("__ie", "che", "chi"), // che (cheie)
        Triple("__lner", "che", "chi"), // che (chelner)
        Triple("__ltuială", "che", "chi"), // che (cheltuiala)
        Triple("__mare", "che", "chi"), // che (chemare)
        Triple("__stionar", "che", "chi"), // che (chestionar)
        Triple("a des__ia", "che", "chi"), // che (a descheia)
        Triple("despa__tare", "che", "chi"), // che (despachetare)
        Triple("eti__tă", "che", "chi"), // che (eticheta)
        Triple("a în__ia", "che", "chi"), // che (a incheia)
        Triple("ja__tă", "che", "chi"), // che (jacheta)
        Triple("o__lari", "che", "chi"), // che (ochelari)
        Triple("pa__t", "che", "chi"), // che (pachet)
        Triple("ra__tă", "che", "chi"), // che (racheta)
        Triple("ridi__", "che", "chi"), // che (ridiche)
        Triple("s__let", "che", "chi"), // che (schelet)
        Triple("s__mă", "che", "chi"), // che (schema)
        Triple("ti__t", "che", "chi"), // che (tichet)
        Triple("ure__", "che", "chi"), // che (ureche)

        Triple("a__ziție", "chi", "che"), // chi (achizitie)
        Triple("aș__e", "chi", "che"), // chi (aschie)
        Triple("__brit", "chi", "che"), // chi (chibrit)
        Triple("__ftea", "chi", "che"), // chi (chiftea)
        Triple("__mie", "chi", "che"), // chi (chimie)
        Triple("__n", "chi", "che"), // chi (chin)
        Triple("__nez", "chi", "che"), // chi (chinez)
        Triple("__peș", "chi", "che"), // chi (chipeș)
        Triple("__rie", "chi", "che"), // chi (chirie)
        Triple("__rurg", "chi", "che"), // chi (chirurg)
        Triple("__tanță", "chi", "che"), // chi (chitanta)
        Triple("__tară", "chi", "che"), // chi (chitară)
        Triple("__uvetă", "chi", "che"), // chi (chiuveta)
        Triple("cior__ne", "chi", "che"), // chi (ciorchine)
        Triple("des__de", "chi", "che"), // chi (deschide)
        Triple("e__libru", "chi", "che"), // chi (echilibru)
        Triple("e__pa", "chi", "che"), // chi (echipa)
        Triple("în__de", "chi", "che"), // chi (inchide)
        Triple("în__soare", "chi", "che"), // chi (inchisoare)
        Triple("li__d", "chi", "che"), // chi (lichid)
        Triple("ma__aj", "chi", "che"), // chi (machiaj)
        Triple("o__", "chi", "che"), // chi (ochi)
        Triple("re__n", "chi", "che"), // chi (rechin)
        Triple("re__zite", "chi", "che"), // chi (rechizite)
        Triple("ro__e", "chi", "che"), // chi (rochie)
        Triple("s__mbare", "chi", "che"), // chi (schimbare)
        Triple("s__ță", "chi", "che"), // chi (schita)
        Triple("s__", "chi", "che"), // chi (schi)
        Triple("ș__op", "chi", "che"), // chi (schiop)
        Triple("trun__", "chi", "che"), // chi (trunchi)
        Triple("ve__", "chi", "che"), // chi (vechi)

        Triple("în__suială", "ghe", "ghi"), // ghe (inghesuiala)
        Triple("în__țată", "ghe", "ghi"), // ghe (inghetată)
        Triple("li__an", "ghe", "ghi"), // ghe (lighean)
        Triple("privi__toare", "ghe", "ghi"), // ghe (privighetoare)
        Triple("spa__te", "ghe", "ghi"), // ghe (spaghete)
        Triple("suprave__tor", "ghe", "ghi"), // ghe (supraveghetor)
        Triple("ve__re", "ghe", "ghi"), // ghe (veghere)
        Triple("__ozdan", "ghi", "ghe"), // ghi (ghiozdan)
        Triple("__nion", "ghi", "ghe"), // ghi (ghinion)
        Triple("__d", "ghi", "ghe"), // ghi (ghid)
        Triple("__don", "ghi", "ghe"), // ghi (ghidon)
        Triple("__ndă", "ghi", "ghe"), // ghi (ghinda)
        Triple("__șeu", "ghi", "ghe"), // ghi (ghiseu)
        Triple("__veci", "ghi", "ghe"), // ghi (ghiveci)
        Triple("dreptun__", "ghi", "ghe"), // ghi (dreptunghi)
        Triple("ma__ar", "ghi", "ghe"), // ghi (maghiar)
        Triple("su__ț", "ghi", "ghe"), // ghi (sughit)
        Triple("triun__", "ghi", "ghe"), // ghi (triunghi)
        Triple("__ocel", "ghi", "ghe"), // ghi (ghiocel)
        Triple("cara__os", "ghi", "ghe"), // ghi (caraghios)
        Triple("frân__e", "ghi", "ghe"), // ghi (franghie)
        Triple("în__țitură", "ghi", "ghe"), // ghi (inghititura)
        Triple("un__e", "ghi", "ghe") // ghi (unghie)
    )

    private var correctAnswer: String = ""
    private var currentQuestion: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grupuri_litere)

        val tvQuestion: TextView = findViewById(R.id.tvQuestion)
        val btnOption1: Button = findViewById(R.id.btnOption1)
        val btnOption2: Button = findViewById(R.id.btnOption2)
        val tvResult: TextView = findViewById(R.id.tvResult)

        fun generateQuestion() {
            // Alegem o întrebare aleatorie din listă
            val question = wordGroups.random()

            // Alegem aleatoriu ordinea opțiunilor
            val options = listOf(question.second, question.third).shuffled()

            // Setăm întrebarea și opțiunile
            currentQuestion = question.first
            correctAnswer = question.second // Prima opțiune din Triple este întotdeauna corectă
            tvQuestion.text = "Completează cuvântul: ${question.first}"
            btnOption1.text = options[0]
            btnOption2.text = options[1]

            // Curățăm rezultatul
            tvResult.text = ""
        }

        fun checkAnswer(selectedAnswer: String) {
            val fullWord = currentQuestion.replace("__", correctAnswer)
            if (selectedAnswer == correctAnswer) {
                tvResult.text = "Corect! Cuvântul este: $fullWord 🎉"
                tvResult.setTextColor(getColor(android.R.color.holo_green_dark))
            } else {
                tvResult.text = "Greșit! Cuvântul corect era: $fullWord."
                tvResult.setTextColor(getColor(android.R.color.holo_red_light))
            }

            // Generăm o nouă întrebare după 2 secunde
            tvResult.postDelayed({
                generateQuestion()
            }, 2500)
        }

        // Setăm evenimentele pentru butoane
        btnOption1.setOnClickListener { checkAnswer(btnOption1.text.toString()) }
        btnOption2.setOnClickListener { checkAnswer(btnOption2.text.toString()) }

        // Generăm prima întrebare
        generateQuestion()
    }
}