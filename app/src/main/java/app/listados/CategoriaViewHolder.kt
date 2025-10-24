package app.listados

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.android_inicializacion.R

class CategoriaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nombreCategoria: TextView = view.findViewById(R.id.nombreCategoria)
    private val contenedorCategoria: CardView = view.findViewById(R.id.contenedorCategoria)

    fun render(categoria: TareaCategoria, onItemSelected: (Int) -> Unit) {
        val color = if (categoria.isSelected) {
            R.color.listados_categoria_contenedor
        } else {
            R.color.white
        }

        contenedorCategoria.setCardBackgroundColor(ContextCompat.getColor(contenedorCategoria.context, color))
        nombreCategoria.text = categoria.toString()

        itemView.setOnClickListener { onItemSelected(layoutPosition) }
    }
}