package app.comida

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_inicializacion.R

class ComidaActivity : AppCompatActivity() {
    lateinit var perroCard: androidx.cardview.widget.CardView
    lateinit var gatoCard: androidx.cardview.widget.CardView
    var selectedCard: androidx.cardview.widget.CardView? = null
    lateinit var slidePeso: SeekBar
    lateinit var pesoValor: TextView
    lateinit var btnSumarEdad: androidx.appcompat.widget.AppCompatButton
    lateinit var btnRestarEdad: androidx.appcompat.widget.AppCompatButton
    lateinit var edadValor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_comida_animales)
        inicializarComponentes()
        inicializarListeners()
    }

    private fun inicializarComponentes() {
        perroCard = findViewById<androidx.cardview.widget.CardView>(R.id.perro)
        gatoCard = findViewById<androidx.cardview.widget.CardView>(R.id.gato)
        slidePeso = findViewById<SeekBar>(R.id.slidePeso)
        pesoValor = findViewById<TextView>(R.id.peso)
        btnSumarEdad = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnSumarEdad)
        btnRestarEdad = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnRestarEdad)
        edadValor = findViewById<TextView>(R.id.edad)
    }

    private fun inicializarListeners() {
        perroCard.setOnClickListener {
            seleccionarCarta(perroCard)
        }

        gatoCard.setOnClickListener {
            seleccionarCarta(gatoCard)
        }

        slidePeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                pesoValor.text = "$progress kg"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        btnSumarEdad.setOnClickListener {
            sumarORestarEdad("suma")
        }

        btnRestarEdad.setOnClickListener {
            sumarORestarEdad("resta")
        }
    }

    fun seleccionarCarta(card: androidx.cardview.widget.CardView) {
        var colorNormal = getColor(R.color.comidas_animales_cardview)
        var colorSelected = getColor(R.color.comidas_animales_cardview_selected)

        selectedCard?.setCardBackgroundColor(colorNormal)
        card.setCardBackgroundColor(colorSelected)
        selectedCard = card
    }

    fun sumarORestarEdad(operacion: String) {
        var edad = edadValor.text.toString().toInt()
        if (operacion == "suma") {
            edad++
        } else if (operacion == "resta") {
            if (edad > 0) {
                edad--
            }
        }
        edadValor.text = edad.toString()
    }
}