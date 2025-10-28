package app.agenda

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_inicializacion.R

class ContactoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nombreContacto: TextView = view.findViewById(R.id.nombreContacto)
    private val telefonoContacto: TextView = view.findViewById(R.id.telefonoContacto)

    fun render(contacto: Contacto) {
        nombreContacto.text = contacto.nombre
        telefonoContacto.text = contacto.telefono.toString()
    }
}