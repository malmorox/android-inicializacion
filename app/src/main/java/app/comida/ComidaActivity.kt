package app.comida

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
    var edad: Int = 0
    var peso: Int = 0

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
                peso = progress
                actualizarPesoComida()
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
        actualizarPesoComida()
    }

    fun sumarORestarEdad(operacion: String) {
        edad = edadValor.text.toString().toInt()
        if (operacion == "suma") {
            edad++
        } else if (operacion == "resta") {
            if (edad > 0) {
                edad--
            }
        }
        edadValor.text = edad.toString()
        actualizarPesoComida()
    }

    // Función prporcionada por el profesor
    private fun calcularPesoComida(): Float {
        var percentAge: Double = 0.0
        var percentWeight: Double = 0.0

        when (selectedCard?.id) {
            R.id.perro -> {
                percentWeight = ((peso!! * 30) + 70).toDouble()
                percentAge = when {
                    edad!! <= 1 -> 1.20
                    edad!! > 8 -> 0.85
                    else -> 1.0
                }
            }
            R.id.gato -> {
                percentWeight = ((peso!! * 25) + 50).toDouble()
                percentAge = when {
                    edad!! <= 1 -> 1.15
                    edad!! > 10 -> 0.90
                    else -> 1.0
                }
            }
            else -> {
                percentWeight = 0.0
                percentAge = 1.0
            }
        }

        return (percentWeight * percentAge).toFloat()
    }

    private fun actualizarPesoComida() {
        var pesoComida = calcularPesoComida()
        var pesoComidaFinal = if (pesoComida > 0) {
            String.format("%.2f", pesoComida) + " g"
        } else {
            "0 g"
        }
        var resultadoPesoComida = findViewById<TextView>(R.id.pesoComida)
        resultadoPesoComida.text = pesoComidaFinal
    }
}