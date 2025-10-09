package app.comida

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primera_app.R

class ComidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_comida_animales)

        var perroCard = findViewById<androidx.cardview.widget.CardView>(R.id.perro)
        var gatoCard = findViewById<androidx.cardview.widget.CardView>(R.id.gato)

        val colorNormal = getColor(R.color.comidas_animales_cardview)
        val colorSelected = getColor(R.color.comidas_animales_cardview_selected)

        var selectedCard: androidx.cardview.widget.CardView? = null

        fun seleccionarCarta(card: androidx.cardview.widget.CardView) {
            selectedCard?.setCardBackgroundColor(colorNormal)
            card.setCardBackgroundColor(colorSelected)
            selectedCard = card
        }

        perroCard.setOnClickListener {
            seleccionarCarta(perroCard)
        }
        gatoCard.setOnClickListener {
            seleccionarCarta(gatoCard)
        }
    }
}