package app.listados

public class Tarea {
    private var titulo: String = ""
    private var descripcion: String = ""
    private var categoria: TareaCategoria = TareaCategoria.Otros

    fun getTitulo(): String {
        return titulo
    }

    fun setTitulo(titulo: String) {
        this.titulo = titulo
    }

    fun getDescripcion(): String {
        return descripcion
    }

    fun setDescripcion(descripcion: String) {
        this.descripcion = descripcion
    }

    fun getCategoria(): TareaCategoria {
        return categoria
    }

    fun setCategoria(categoria: TareaCategoria) {
        this.categoria = categoria
    }
}