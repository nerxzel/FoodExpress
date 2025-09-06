class Comida(nombre:String,
             precio:Double,
             esPremium:Boolean,
             tiempoPreparacion: Int):Producto(nombre, precio, esPremium, tiempoPreparacion) {

    override fun mostrarInfo(): String {
        return "$nombre: \$${"%,d".format(precio)}"
    }
}