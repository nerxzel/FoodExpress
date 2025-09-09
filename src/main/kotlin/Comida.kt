class Comida(nombre: String,
             precioInicial: Int,
             tiempoPreparacionMin: Int,
             val esPremium: Boolean): Producto(nombre,
                                               precioInicial,
                                               categoria = "Comida",
                                               tiempoPreparacionMin) {

    override fun mostrarInfo(): String {
        return "$nombre: $${"%,d".format(precioFinal())}"
    }

    override fun precioFinal(): Int {
        if (esPremium)
           return (precioInicial * 1.10).toInt()

        return precioInicial
    }
}