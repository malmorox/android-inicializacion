import android.content.res.ColorStateList
import android.graphics.Paint
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import app.listados.Tarea
import app.listados.TareaCategoria
import com.example.android_inicializacion.R
import com.google.android.material.card.MaterialCardView

class TareaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val contenedorTarea: MaterialCardView = view.findViewById(R.id.contenedorTarea)
    private val nombreTarea: TextView = view.findViewById(R.id.nombreTarea)
    private val checkboxTarea: CheckBox = view.findViewById(R.id.checkboxTarea)

    fun render(tarea: Tarea) {
        nombreTarea.text = tarea.nombre

        val color = tarea.categoria.obtenerColor(checkboxTarea.context)

        contenedorTarea.strokeColor = color
        contenedorTarea.strokeWidth = 4

        checkboxTarea.buttonTintList = ColorStateList.valueOf(color)

        checkboxTarea.setOnCheckedChangeListener { _, marcado ->
            tarea.isSelected = marcado
            cambiarEstado(marcado)
        }

        nombreTarea.setOnClickListener {
            tarea.isSelected = !tarea.isSelected
            cambiarEstado(tarea.isSelected)
            checkboxTarea.isChecked = tarea.isSelected
        }
    }

    private fun cambiarEstado(estaHecha: Boolean) {
        if (estaHecha) {
            nombreTarea.paintFlags = nombreTarea.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            nombreTarea.paintFlags = nombreTarea.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        checkboxTarea.isChecked = estaHecha
    }
}