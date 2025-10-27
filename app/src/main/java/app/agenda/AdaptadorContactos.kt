package app.agenda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat
import com.example.android_inicializacion.R

class AdaptadorContactos(private val contactos: List<Contacto>) :
    RecyclerView.Adapter<ContactoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {

    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {

    }

    override fun getItemCount() = contactos.size
}