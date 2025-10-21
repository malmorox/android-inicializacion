package app.listados

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat
import com.example.android_inicializacion.R

class AdaptadorCategorias(
    private val categorias: List<TareaCategoria>,
    private val onCategoriaClick: (TareaCategoria) -> Unit
) : RecyclerView.Adapter<CategoriaViewHolder>() {

    private var categoriaSeleccionada: TareaCategoria? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categoria, parent, false)
        return CategoriaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        val categoria = categorias[position]
        holder.nombreCategoria.text = categoria.toString()

        val context = holder.itemView.context
        val colorSeleccionado = ContextCompat.getColor(context, R.color.listado_boton)
        val colorNormal = ContextCompat.getColor(context, android.R.color.white)

        holder.card.setCardBackgroundColor(
            if (categoria == categoriaSeleccionada) colorSeleccionado else colorNormal
        )

        holder.itemView.setOnClickListener {
            categoriaSeleccionada = categoria
            onCategoriaClick(categoria)
        }
    }

    override fun getItemCount(): Int = categorias.size
}