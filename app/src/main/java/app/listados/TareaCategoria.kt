package app.listados

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.android_inicializacion.R

sealed class TareaCategoria(var isSelected:Boolean = true) {
    abstract fun obtenerColor(context: Context): Int

    object Deportes: TareaCategoria() {
        override fun obtenerColor(context: Context) = ContextCompat.getColor(context, R.color.listados_categoria_deportes)
    }
    object Trabajo: TareaCategoria() {
        override fun obtenerColor(context: Context) = ContextCompat.getColor(context, R.color.listados_categoria_trabajo)
    }
    object Hogar: TareaCategoria() {
        override fun obtenerColor(context: Context) = ContextCompat.getColor(context, R.color.listados_categoria_hogar)
    }
    object Otros: TareaCategoria() {
        override fun obtenerColor(context: Context) = ContextCompat.getColor(context, R.color.listados_categoria_otros)
    }

    override fun toString(): String = when (this) {
        Deportes -> "Deportes"
        Trabajo -> "Trabajo"
        Hogar -> "Hogar"
        Otros -> "Otros"
    }
}