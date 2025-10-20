package app.listados

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.example.android_inicializacion.R

class CategoriaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val card: MaterialCardView = view as MaterialCardView
    val nombreCategoria: TextView = view.findViewById(R.id.nombreCategoria)
}