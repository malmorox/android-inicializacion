package app.listados

data class Tarea (val nombre: String, val categoria: TareaCategoria, var isSelected:Boolean = false)