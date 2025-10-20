package app.listados

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_inicializacion.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListadosActivity : AppCompatActivity() {
    private lateinit var botonAgregarTarea: FloatingActionButton
    private lateinit var recyclerCategorias: RecyclerView

    private lateinit var adaptadorCategorias: AdaptadorCategorias

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listados)

        inicializarComponentes()
        inicializarListeners()
    }

    private fun inicializarComponentes() {
        botonAgregarTarea = findViewById(R.id.agregarTarea)
        recyclerCategorias = findViewById(R.id.categorias)

        val listaCategorias = listOf(
            TareaCategoria.Deportes,
            TareaCategoria.Trabajo,
            TareaCategoria.Hogar,
            TareaCategoria.Otros
        )

        recyclerCategorias.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adaptadorCategorias = AdaptadorCategorias(listaCategorias) { categoria ->

        }

        recyclerCategorias.adapter = adaptadorCategorias
    }

    private fun inicializarListeners() {
        botonAgregarTarea.setOnClickListener {

        }
    }
}