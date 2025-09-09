import kotlin.math.roundToInt

class Bebida(nombre: String,
             precioInicial: Int,
             tiempoPreparacionMin: Int,
             val tamanho: TamanhoBebida) :Producto(nombre,
                                                  precioInicial,
                                                  categoria = "Bebida",
                                                  tiempoPreparacionMin) {

    override fun mostrarInfo(): String {
        return "$nombre ($tamanho): $${"%,d".format(precioFinal())}"
    }

    override fun precioFinal(): Int {
        return (precioInicial * tamanho.multiplicador).roundToInt()
    }
}