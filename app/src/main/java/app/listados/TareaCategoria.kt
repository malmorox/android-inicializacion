package app.listados

sealed class TareaCategoria {
    object Deportes: TareaCategoria()
    object Trabajo: TareaCategoria()
    object Hogar: TareaCategoria()
    object Otros: TareaCategoria()
}