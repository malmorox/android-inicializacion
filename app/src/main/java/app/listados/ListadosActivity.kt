package app.listados

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_inicializacion.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListadosActivity : AppCompatActivity() {
    private val categorias = listOf(
        TareaCategoria.Deportes,
        TareaCategoria.Trabajo,
        TareaCategoria.Hogar,
        TareaCategoria.Otros
    )

    private val tareas = mutableListOf(
        Tarea("PruebaDeportes", TareaCategoria.Deportes),
        Tarea("PruebaHogar", TareaCategoria.Hogar),
        Tarea("PruebaTrabajo", TareaCategoria.Trabajo)
    )

    private lateinit var recyclerCategorias: RecyclerView
    private lateinit var adaptadorCategorias: AdaptadorCategorias

    private lateinit var recyclerTareas: RecyclerView
    private lateinit var adaptadorTareas: AdaptadorTareas

    private lateinit var botonAbrirModal: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listados)
        inicializarComponentes()
        inicializarUI()
        inicializarListeners()
    }

    private fun inicializarComponentes() {
        recyclerCategorias = findViewById(R.id.rvCategorias)
        recyclerTareas = findViewById(R.id.rvTareas)
        botonAbrirModal = findViewById(R.id.abrirModalAgregarTarea)
    }

    private fun inicializarListeners() {
        botonAbrirModal.setOnClickListener {
            mostrarModal()
        }
    }

    private fun inicializarUI() {
        adaptadorCategorias = AdaptadorCategorias(categorias) {
            posicion -> actualizarCategorias(posicion)
        }

        recyclerCategorias.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerCategorias.adapter = adaptadorCategorias

        adaptadorTareas = AdaptadorTareas(tareas) {
            posicion -> onItemSelected(posicion)
        }

        recyclerTareas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerTareas.adapter = adaptadorTareas
    }

    private fun actualizarCategorias(posicion: Int){
        categorias[posicion].isSelected = !categorias[posicion].isSelected
        adaptadorCategorias.notifyItemChanged(posicion)
        actualizarTareas()
    }

    private fun actualizarTareas(){
        val selectedCategories: List<TareaCategoria> = categorias.filter { it.isSelected }
        val nuevasTareas = tareas.filter { selectedCategories.contains(it.categoria) }
        adaptadorTareas.tareas = nuevasTareas
        adaptadorTareas.notifyDataSetChanged()
    }

    private fun onItemSelected(posicion:Int){
        tareas[posicion].isSelected = !tareas[posicion].isSelected
        actualizarTareas()
    }


    private fun mostrarModal(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialogo_tarea)

        val botonAgregarTarea: Button = dialog.findViewById(R.id.botonAgregarTarea)
        val campoTarea: EditText = dialog.findViewById(R.id.campoTarea)
        val seleccionCategoria: RadioGroup = dialog.findViewById(R.id.rgCategories)

        botonAgregarTarea.setOnClickListener {
            val currentTask = campoTarea.text.toString().trim()
            if(currentTask.isNotEmpty()){
                val selectedId = seleccionCategoria.checkedRadioButtonId
                val selectedRadioButton: RadioButton = seleccionCategoria.findViewById(selectedId)
                val currentCategory: TareaCategoria = when(selectedRadioButton.id){
                    R.id.radioDeportes -> TareaCategoria.Deportes
                    R.id.radioTrabajo -> TareaCategoria.Trabajo
                    R.id.radioHogar -> TareaCategoria.Hogar
                    else -> TareaCategoria.Otros
                }

                tareas.add(Tarea(currentTask, currentCategory))
                actualizarTareas()
                //Log.d("tareas", tareas.toString())
                dialog.hide()
            }
        }

        dialog.show()
    }
}