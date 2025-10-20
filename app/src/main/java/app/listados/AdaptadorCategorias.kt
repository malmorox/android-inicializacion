package app.listados

import androidx.recyclerview.widget.RecyclerView

class AdaptadorCategorias(private val categorias: List<TareaCategoria>) : RecyclerView.Adapter<CategoriaViewHolder>() {
    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): CategoriaViewHolder {
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return categorias.size
    }
}