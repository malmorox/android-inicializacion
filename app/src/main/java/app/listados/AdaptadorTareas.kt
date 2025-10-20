package app.listados

import androidx.recyclerview.widget.RecyclerView

class AdaptadorTareas(private val tareas: List<Tarea>) : RecyclerView.Adapter<TareaViewHolder>() {
    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): TareaViewHolder {
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return tareas.size
    }
}