open class Producto(val nombre: String, var precio: Int) {

    open fun mostrarInfo(): String {
        return "Producto(nombre='$nombre', precio=$precio)"
    }
}