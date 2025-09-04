class Bebida(nombre:String, precio:Int, val tamanho:String):Producto(nombre, precio) {

    override fun mostrarInfo(): String {
        return "$nombre ($tamanho): \$${"%,d".format(precio)}"
    }
}