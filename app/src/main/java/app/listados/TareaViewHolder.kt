import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import app.listados.Tarea
import app.listados.TareaCategoria
import com.example.android_inicializacion.R

class TareaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val nombreTarea: TextView = view.findViewById(R.id.nombreTarea)
    private val checkboxTarea: CheckBox = view.findViewById(R.id.checkboxTarea)

    fun render(tarea: Tarea) {

        if (tarea.isSelected) {
            nombreTarea.paintFlags = nombreTarea.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            nombreTarea.paintFlags = nombreTarea.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        nombreTarea.text = tarea.nombre
        checkboxTarea.isChecked = tarea.isSelected

        val color = when (tarea.categoria) {
            TareaCategoria.Deportes -> R.color.listados_categoria_deportes
            TareaCategoria.Hogar -> R.color.listados_categoria_hogar
            TareaCategoria.Trabajo -> R.color.listados_categoria_trabajo
            TareaCategoria.Otros -> R.color.listados_categoria_otros
        }

        checkboxTarea.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(checkboxTarea.context, color)
        )


    }
}