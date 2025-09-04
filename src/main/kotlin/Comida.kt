class Comida(nombre:String, precio:Int, val esPremium: Boolean):Producto(nombre, precio) {

    override fun mostrarInfo(): String {
        return "$nombre: \$${"%,d".format(precio)}"
    }
}