package app.listados

sealed class TareaCategoria {
    object Deportes: TareaCategoria()
    object Trabajo: TareaCategoria()
    object Hogar: TareaCategoria()
    object Otros: TareaCategoria()

    override fun toString(): String = when (this) {
        Deportes -> "Deportes"
        Trabajo -> "Trabajo"
        Hogar -> "Hogar"
        Otros -> "Otros"
    }
}