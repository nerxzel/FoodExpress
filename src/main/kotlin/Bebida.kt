class Bebida(nombre:String,
             precio:Double,
             esPremium:Boolean,
             tiempoPreparacion: Int,
             val tamanho:String) :Producto(nombre, precio, esPremium, tiempoPreparacion) {

    override fun mostrarInfo(): String {
        return "$nombre ($tamanho): \$${"%,d".format(precio)}"
    }
}