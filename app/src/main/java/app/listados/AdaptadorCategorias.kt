package app.listados

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat
import com.example.android_inicializacion.R

class AdaptadorCategorias(private val categorias: List<TareaCategoria>, private val onItemSelected:(Int) -> Unit) :
    RecyclerView.Adapter<CategoriaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categoria, parent, false)
        return CategoriaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        holder.render(categorias[position], onItemSelected)
    }

    override fun getItemCount() = categorias.size
}