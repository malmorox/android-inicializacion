package app.agenda

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.listados.AdaptadorCategorias
import app.listados.Tarea
import app.listados.TareaCategoria
import com.example.android_inicializacion.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AgendaActivity : AppCompatActivity() {
    private var contactos = mutableListOf<Contacto>(
        Contacto("Lucas", 689413228),
        Contacto("Ana", 699213277)
    )

    private lateinit var recyclerContactos: RecyclerView
    private lateinit var adaptadorContactos: AdaptadorContactos
    private lateinit var botonAbrirModal: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agenda)
        inicializarComponentes()
        inicializarUI()
        inicializarListeners()
    }

    private fun inicializarComponentes() {
        recyclerContactos = findViewById(R.id.rvListadoContactos)
        botonAbrirModal = findViewById(R.id.fabAbrirModalAgregarContacto)
    }

    private fun inicializarUI() {
        adaptadorContactos = AdaptadorContactos(contactos)
        recyclerContactos.layoutManager = LinearLayoutManager(this)
        recyclerContactos.adapter = adaptadorContactos
    }

    private fun inicializarListeners() {
        botonAbrirModal.setOnClickListener {
            mostrarModal()
        }
    }

    private fun mostrarModal() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialogo_contacto)

        //val campoNombre = dialog.findViewById<EditText>(R.id.etNombre)
        //val campoTelefono = dialog.findViewById<EditText>(R.id.etTelefono)
        //val botonAgregarContacto = dialog.findViewById<Button>(R.id.btnGuardar)
    }
}