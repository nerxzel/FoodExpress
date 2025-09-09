open class Producto(val nombre: String,
                    val precioInicial: Int,
                    val categoria: String,
                    val tiempoPreparacionMin: Int) {

    open fun precioFinal(): Int {
       return precioInicial
    }

    open fun mostrarInfo(): String {
        return "$nombre: $${"%,d".format(precioInicial)}"
    }
}