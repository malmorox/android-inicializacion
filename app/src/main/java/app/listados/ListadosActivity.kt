package app.listados

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_inicializacion.R

class ListadosActivity : AppCompatActivity() {

    lateinit var botonAgregarTarea : com.google.android.material.floatingactionbutton.FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listados)
        inicializarComponentes()
        inicializarListeners()
    }

    private fun inicializarComponentes() {

    }

    private fun inicializarListeners() {
        botonAgregarTarea.setOnClickListener {

        }
    }
}